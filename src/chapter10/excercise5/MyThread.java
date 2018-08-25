package chapter10.excercise5;

import chapter10.GracefulThread;

public class MyThread extends GracefulThread {
	private int count = 0;
	
	@Override
	protected void doShutdown() {
		System.out.println("done.");
	}

	@Override
	protected void doWork() throws InterruptedException {
		System.out.print(".");
		Thread.sleep(100);
		count++;
		if (count >= 50) {
			this.shutdownRequest();
		}
	}

}
