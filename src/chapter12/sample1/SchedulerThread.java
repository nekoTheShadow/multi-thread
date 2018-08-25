package chapter12.sample1;

public class SchedulerThread<T> extends Thread {
	private final ActivationQueue<T> queue;
	
	public SchedulerThread(ActivationQueue<T> queue) {
		this.queue = queue;
	}
	
	public void invoke(MethodRequest<T> request) {
		this.queue.putRequest(request);
	}
	
	public void run() {
		while (true) {
			var request = queue.takeRequest();
			request.execute();
		}
	}
}
