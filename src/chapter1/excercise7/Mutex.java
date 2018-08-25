package chapter1.excercise7;

public class Mutex {
	private boolean isLocked;
	
	public synchronized void lock() {
		while (isLocked) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				// PASS
			}
		}
		this.isLocked = true;
	}
	
	public synchronized void unlock() {
		this.isLocked = false;
		this.notifyAll();
	}
}
