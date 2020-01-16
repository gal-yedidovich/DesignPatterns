package com.ctera.util.concurrency;

import android.os.Handler;
import android.os.Looper;

import com.ctera.util.Console;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.Executor;

import androidx.annotation.NonNull;

/**
 * Create By Gal Yedidovich on 10/9/2017.
 * <p>
 * Thread Pool
 * <p>
 * Runs operations asynchronously and manages threads automatically.
 * this version is a Multiton - multiple immutable instances.
 * This Pool enables you to execute Async UI operations.
 * <p>
 * the motivation is based on AsyncTask, which have a deprivation issue when executing multiple instances.
 * UITask & ProgressedTask are immune to thread deprivation because they execute tasks on a thread pool.
 * <p>
 * the Thread pool implements Executor interface to works with standard libraries and APIs.
 * for example: PrecomputedTextCompat.getTextFuture method accepts an Executor for concurrency control.
 * <p>
 * there are 3 pool: <br/>
 * - main:      used for most operations, usually short. <br/>
 * - longTasks: used for uploads & downloads, usually long operations. <br/>
 * - low:       used for logging & updating shared preferences, this pool has one thread, to sync operation by order FIFO<br/>
 * <p>
 * we use 3 pools to separate operations queues, like in case of multiple parallel uploads/downloads.
 */
public enum ThreadPool implements Executor {
	main(1, 5), longTasks(1, 5), low(1, 1);
	
	//region handling in UI main thread
	private static final Handler handler = new Handler(Looper.getMainLooper());
	
	/**
	 * run an operation in UI thread
	 *
	 * @param target operation to execute.
	 */
	public static void post(Runnable target) {
		if (Looper.myLooper() == Looper.getMainLooper()) target.run();
		else handler.post(target);
	}
	
	/**
	 * run an operation in UI thread after a delay.
	 *
	 * @param target operation to execute.
	 * @param delay  time to wait before running task
	 */
	public static void post(Runnable target, long delay) {
		handler.postDelayed(target, delay);
	}
	//endregion
	
	private static final String TAG = ThreadPool.class.getSimpleName();
	private final Stack<String> threadNames;
	private final int min, max;
	private Queue<Runnable> waitingQueue = new ArrayDeque<>(); //queue of waiting tasks
	private ArrayList<InnerExecutor> threads = new ArrayList<>(); //collection of executors that work concurrently.
	
	/**
	 * Initialize new Pool object with number of executors.
	 *
	 * @param min number of initial threads.
	 * @param max maximum number of thread to be created a peak points.
	 */
	ThreadPool(int min, int max) {
		threadNames = new Stack<>();
		this.min = min;
		this.max = max;
		for (int i = 1; i <= max; i++) {
			String name = name() + " Pool, Thread #" + i;
			if (i <= min) threads.add(new InnerExecutor(name));
			else threadNames.add(0, name); //adding FIFO for better numbering (LIFO is better later)
		}
	}
	
	/**
	 * Run new runnable operation in Thread pool.
	 * The pool searches for inactive executor and if found, it executes the task.
	 * <p>
	 * if all executors are busy, add task to waiting queue.
	 * <p>
	 * Thread safe.
	 *
	 * @param target new operation to run asynchronously.
	 */
	public synchronized void execute(@NonNull final Runnable target) {
		for (InnerExecutor t : threads) {
			if (!t.isWorking) {
				t.execute(target);
				return;
			}
		}
		
		if (threads.size() < max) {
			InnerExecutor executor = new InnerExecutor(threadNames.pop());
			threads.add(executor);
			executor.execute(target);
		} else waitingQueue.add(target);
	}
	
	/**
	 * Event handler to handle inactive threads,
	 * when a Executor finishes a task, it will notify the pool.
	 * <p>
	 * first, double check that executor isn't busy & waiting queue is not empty.
	 * if true -> assign task & return true
	 * else -> return false, to indicate that there is no task to execute right now.
	 * <p>
	 * Thread safe
	 *
	 * @param exec the Executor that done it's task
	 * @return true if new task has been assigned to executor, otherwise false.
	 */
	private synchronized boolean onTaskDone(final InnerExecutor exec) {
		if (!exec.isWorking && !waitingQueue.isEmpty()) {
			exec.execute(waitingQueue.remove());
			return true;
		} else if (waitingQueue.isEmpty() && threads.size() > min) {
			threads.remove(exec);
			threadNames.add(exec.thread.getName());
			exec.isAlive = false;
			return true;
		}
		return false;
	}
	
	private class InnerExecutor implements Runnable {
		private boolean isWorking, isAlive;
		private Thread thread;
		private Runnable target;
		
		InnerExecutor(String name) {
			thread = new Thread(this);
			thread.setName(name);
			isWorking = false;
			isAlive = true;
		}
		
		synchronized void execute(Runnable target) {
			isWorking = true;
			this.target = target;
			
			if (thread.getState() == Thread.State.NEW) thread.start(); //lazy staring
			notifyAll();
		}
		
		@Override
		public void run() {
			Console.println(TAG, "created!");
			while (isAlive) {
				try {
					target.run();
					isWorking = false;
					if (onTaskDone(this)) continue; //move to next task
					
					target = null; //TODO - remove when determined if should call "wait()" in loop or not.
					if (ThreadPool.this != low) Console.println(TAG, "waiting"); //ignore "low" pool
					synchronized (this) {
						wait();
					}
				} catch (InterruptedException e) {
					Console.println("Thread pool", "waiting");
				}
			}
			Console.println(TAG, "done");
		}
	}
}
