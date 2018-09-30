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
     * <p>
     * Thread safe.
     *
     * @param target new operation to run a DispatchQueue.
     */
    public synchronized void async(final Runnable target) {
        var dq = queues.get(0);
        for (int i = 1; i < queues.size(); i++) { //find smallest queue.
            if (dq.size() == 0) break; //if current dq is empty - then no need to continue.

            var temp = queues.get(i);
            if (temp.size() < dq.size()) dq = temp;
        }

        dq.add(target); //add to smallest queue - will run automatically.

        //if smallest queue is big(has more than 5 operations running) & we have less than 9 queues, add new queue.
        if (dq.size() > 5 && queues.size() < 9) increaseCapacity();
    }

    /**
     * Add another dispatch queue to pool.
     * <b>Not thread safe</b>.
     */
    private void increaseCapacity() {
        System.out.println("increasing capacity"); //print
        queues.add(new DispatchQueue("thread #" + ++threadNums)); //add new DP to pool
    }

    /**
     * Kill all threads
     * Thread safe
     */
    @Override
    public void close() {
        synchronized (this) {
            System.out.println("Thread pool - kill");
            for (DispatchQueue t : queues) t.kill();
        }
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
    private synchronized void onThreadInactive(final DispatchQueue dq) {
        if (dq.queue.isEmpty() && queues.size() > 3) { //double check that DP is still inactive, AND if pool has move than 3 dispatch queues, remove this one.
            dq.kill(); //dispose thread
            queues.remove(dq); //remove from pool
        }
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
        public DispatchQueue(String name) {
            thread = new Thread(this);
            thread.setName(name);
            queue = new ArrayDeque<>();
            isAlive = false; //at first thread is not running, then it's not alive.
        }

        /**
         * @return size of operations queue.
         */
        public int size() {
            return queue.size();
        }

        /**
         * Add new operation to Dispatch Queue.
         *
         * @param target new operation in queue.
         */
        public synchronized void add(Runnable target) {
            if (thread.getState() == Thread.State.NEW) {
                isAlive = true; //thread is alive.
                thread.start();//lazy starting.
            }
            queue.add(target);
            notifyAll();
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
            while (isAlive || !queue.isEmpty()) //if dispatch queue is alive OR there are still some tasks to execute.
                if (!queue.isEmpty()) queue.remove().run(); //run operation.
                else {
                    try {
                        onThreadInactive(this); //notify pool that this thread is idle, and kill if needed.
                        //Lock double checking, check if pool killed this thread, if not then wait until notifying.
                        if (isAlive) {
                            synchronized (this) {
                                if (isAlive) {
                                    System.out.println(thread.getName() + " - waiting");
                                    wait();
                                }
                            }
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            System.out.println(thread.getName() + " - Done");
        }

        /**
         * Kill this thread.
         * <p>
         * Turns isAlive to false, meaning to break the 'while' loop in run method.
         * also notify waiting threads.
         */
        public synchronized void kill() {
            isAlive = false;
            notifyAll();
        }
    }
}
