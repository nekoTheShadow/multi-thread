package chapter10.excercise2;

public class CountupThread extends Thread {
	private long counter = 0;
	
	public void shutdownRequest() {
		this.interrupt();
	}

	public void run() {
		try {
			while (!this.isInterrupted()) {
				doWork();
			}
		} finally {
			doShutdown();
		}
	}
	
	private void doWork() {
		counter++;
		System.out.println("doWork: counter = " + counter);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// PASS
		}
	}
	
	private void doShutdown() {
		System.out.println("doShutdown: counter = " + counter);
	}
}
