package concurrency_patterns.thread_pool;

import java.io.Closeable;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

/**
 * Thread Pool
 * <p>
 * Runs operations asynchronously and manages threads automatically.
 */
class ThreadPool implements Closeable {
    private int threadNums;//numbering thread names
    private DispatchQueue managerQueue = new DispatchQueue("manager thread"); //queue that synchronize pool methods.
    private ArrayList<DispatchQueue> queues = new ArrayList<>(); //collection of dispatch queues that work concurrently.

    /**
     * Initialize new Poll object with three dispatchQueue.
     * and a managerQueue to synchronize operations.
     */
    public ThreadPool() {
        for (int i = 0; i < 3; i++) increaseCapacity(); //start with 3 dispatch queues.
    }

    /**
     * Run new runnable operation in thread pool.
     * The pool selects the smallest queue to run the operation.
     * <p>
     * When all DispatchQueues has more than 5 operations, create another DispatchQueue if possible.
     *
     * Thread safe.
     * @param target new operation to run a DispatchQueue.
     */
    public void async(final Runnable target) {
        sync(() -> {
            var dq = queues.get(0);
            for (int i = 1; i < queues.size(); i++) { //find smallest queue.
                if (dq.size() == 0) break; //if current dq is empty - then no need to continue.

                var temp = queues.get(i);
                if (temp.size() < dq.size()) dq = temp;
            }

            dq.add(target); //add to smallest queue - will run automatically.

            //if smallest queue is big(has more than 5 operations running) & we have less than 9 queues, add new queue.
            if (dq.size() > 5 && queues.size() < 9) increaseCapacity();
        });
    }

    /**
     * Add another dispatch queue to pool.
     * <b>Not thread safe</b>.
     */
    private void increaseCapacity() {
        System.out.println("increasing capacity"); //print
        queues.add(new DispatchQueue("thread #" + ++threadNums)); //add new DP to pool
    }

    @Override
    public void close() {
        dispose();
    }

    /**
     * Run operation in manager DispatchQueue,
     * Makes operations thread safe.
     *
     * @param operation runnable implementation to run synchronously in manager DispatchQueue.
     */
    private synchronized void sync(final Runnable operation) {
        managerQueue.add(operation);
    }

    /**
     * Event handler to handle inactive threads,
     * when a DispatchQueue is inactive (its queue is empty), it will notify the pool
     * <p>
     * This method will ignore managerQueue when it is inactive.
     * Thread safe
     *
     * @param dq the DispatchQueue that called inactive
     */
    private void onThreadInactive(final DispatchQueue dq) {
        if (dq == managerQueue) return; //ignore manager Queue∫

        sync(() -> {
            if (dq.queue.isEmpty() && queues.size() > 3) { //double check that DP is still inactive, AND if pool has move than 3 dispatch queues, remove this one.
                dq.kill(); //dispose thread
                queues.remove(dq); //remove from poo˜l
            }
        });
    }

    /**
     * Kill all threads
     * Thread safe
     */
    private void dispose() {
        sync(() -> {
            System.out.println("Thread pool - kill");
            for (DispatchQueue t : queues) t.kill();
            managerQueue.kill();
        });
    }

    private class DispatchQueue implements Runnable {
        private boolean isAlive; //boolean indicating thread is still working
        private Queue<Runnable> queue; //queue of runnable operations
        private Thread thread; //the thread which runs operations

        /**
         * Initialize new DQ object.
         *
         * @param name name of the thread inside the DQ.
         */
        DispatchQueue(String name) {
            thread = new Thread(this);
            thread.setName(name);
            queue = new ArrayDeque<>();
            isAlive = false; //at first thread is not running, then it's not alive.
        }

        /**
         * @return size of operations queue.
         */
        int size() {
            return queue.size();
        }

        /**
         * Add new operation to Dispatch Queue.
         *
         * @param target new operation in queue.
         */
        void add(Runnable target) {
            if (thread.getState() == Thread.State.NEW) {
                isAlive = true; //thread is alive.
                thread.start();//lazy starting.
            }
            queue.add(target);
        }

        /**
         * Handle queue operations.
         * When queue is not empty, run each operation by order FIFO.
         * <p>
         * When queue is empty, notify pool that DQ is inactive
         * and wait until queue is not empty or thread is killed.
         */
        @Override
        public void run() {
            while (isAlive)
                if (!queue.isEmpty()) queue.remove().run(); //run operation.
                else {
                    try {
                        onThreadInactive(this); //notify pool that this thread is inactive
                        Thread.sleep(20); //wait 20 ms, to save resources
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            System.out.println(thread.getName() + " - Done");
        }

        /**
         * Kill this thread.
         * <p>
         * Turn isAlive to false, meaning to break the 'while' loop in run method.
         */
        void kill() {
            isAlive = false;
        }
    }
}
