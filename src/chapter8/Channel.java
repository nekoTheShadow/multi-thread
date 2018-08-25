package chapter8;

import java.util.List;
import java.util.Queue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Channel {
	private final Queue<Request> requestQueue = new LinkedBlockingQueue<>();
	private final List<WorkerThread> threadPool;
	
	public Channel(int threads) {
		this.threadPool = IntStream.range(0, threads)
				.mapToObj(i -> new WorkerThread("Worker-" + i, this))
				.collect(Collectors.toCollection(CopyOnWriteArrayList::new));
	}
	
	public void startWorkers() {
		threadPool.forEach(Thread::start);
	}
	
	public synchronized void putRequest(Request request) {
		requestQueue.add(request);
		notifyAll();
	}
	
	public synchronized Request takeRequest() {
		while (requestQueue.isEmpty()) {
			try {
				wait();
			} catch (InterruptedException e) {
				new RuntimeException(e);
			}
		}
		
		var request = requestQueue.remove();
		notifyAll();
		return request;
	}
}
 