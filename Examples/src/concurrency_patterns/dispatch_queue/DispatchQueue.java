package concurrency_patterns.dispatch_queue;

import java.util.ArrayDeque;
import java.util.Queue;

public  class DispatchQueue implements Runnable {
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
                    synchronized (this) {
                        //Lock double checking, check if pool killed this thread, if not then wait until notifying.
                        if (isAlive) {
                            System.out.println(thread.getName() + " - waiting");
                            wait();
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
     * also notifying threads to continue from wait
     */
    public synchronized void kill() {
        isAlive = false;
        notifyAll();
    }
}
