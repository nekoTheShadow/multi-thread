package chapter3;

import java.util.LinkedList;
import java.util.Queue;

import chapter4.LivenessException;

public class RequestQueue {
	private static final long TIMEOUT = 30000L;
	
	private final Queue<Request> queue = new LinkedList<>();
	
	public synchronized Request getRequest() throws InterruptedException {
		long start = System.currentTimeMillis();
		while (queue.peek() == null) {
			long rest = TIMEOUT - (System.currentTimeMillis() - start);
			if (rest < 0) {
				throw new LivenessException("thrown by " + Thread.currentThread().getName());
			}
			
			System.out.printf("%s: wait() begins, queue = %s%n", Thread.currentThread().getName(), queue);
			this.wait();
			System.out.printf("%s: wait() ends, queue = %s%n", Thread.currentThread().getName(), queue);
		}
		return queue.remove();
	}
	
	public synchronized void putRequest(Request request) {
		queue.offer(request);
		System.out.printf("%s: notifiyAll() begins, queue = %s%n", Thread.currentThread().getName(), queue);
		notifyAll();
		System.out.printf("%s: notifiyAll() ends, queue = %s%n", Thread.currentThread().getName(), queue);
	}
	
}
