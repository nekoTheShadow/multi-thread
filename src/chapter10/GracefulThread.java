package chapter10;

public abstract class GracefulThread extends Thread {
	private volatile boolean shutdownRequested = false;
	
	public final void shutdownRequest() {
		shutdownRequested = true;
	}
	
	public final boolean isShutdownRequested() {
		return shutdownRequested;
	}
	
	public final void run() {
		try {
			while (!isShutdownRequested()) {
				doWork();
			}
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		} finally {
			doShutdown();
		}
	}

	protected abstract void doShutdown();
	protected abstract void doWork() throws InterruptedException;
}
