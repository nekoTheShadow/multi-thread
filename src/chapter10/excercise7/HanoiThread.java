package chapter10.excercise7;

public class HanoiThread extends Thread {
	private volatile boolean shutdownRequested = false;
	private volatile long requestedTimeMills = 0;
	
	public void shutdownRequest() {
		requestedTimeMills = System.currentTimeMillis();
		shutdownRequested = true;
		this.interrupt();
	}
	
	public boolean isShutdownRequest() {
		return this.shutdownRequested;
	}
	
	public void run() {
		try {
			for (int level = 0; !isShutdownRequest(); level++) {
				System.out.println("=== Level " + level + " ===");
				doWork(level, 'A', 'B', 'C');
				System.out.println();
			}
		} finally {
			doShutdown();
		}
	}
	
	private void doWork(int level, char posA, char posB, char posC) {
		if (level <= 0) {
			return ;
		}
		
		if (isShutdownRequest()) {
			return ;
		}
		
		doWork(level - 1, posA, posC, posB);
		System.out.println(posA + "->" + posB);
		doWork(level - 1, posC, posB, posA);
	}
	
	private void doShutdown() {
		long time = System.currentTimeMillis() - requestedTimeMills;
		System.out.println("doShutdown: Latency = " + time + " .msec.");
	}
}
