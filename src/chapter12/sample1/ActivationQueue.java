package chapter12.sample1;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;


public class ActivationQueue<T> {
	private static final int MAX_METHOD_REQUEST = 100;
	private final Queue<MethodRequest<T>> requestQueue;
	
	public ActivationQueue() {
		this.requestQueue = new LinkedBlockingQueue<>();
	}
	
	public synchronized void putRequest(MethodRequest<T> request) {
		while(MAX_METHOD_REQUEST <= requestQueue.size()) {
			try {
				wait();
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		}
		requestQueue.add(request);
		notifyAll();
	}
	
	public synchronized MethodRequest<T> takeRequest() {
		while (requestQueue.isEmpty()) {
			try {
				wait();
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}			
		}
		
		var request = requestQueue.poll();
		notifyAll();
		return request;
	}
}
