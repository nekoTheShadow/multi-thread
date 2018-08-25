package chapter12.sample1;

public class DisplayClientThread extends Thread {
	private final ActiveObject activeObject;
	
	public DisplayClientThread(String name, ActiveObject activeObject) {
		super(name);
		this.activeObject = activeObject;
	}
	
	public void run() {
		try {
			for (int i = 0; ; i++) {
				var string = Thread.currentThread().getName() + " " + i;
				activeObject.displayString(string);
				Thread.sleep(200);
			}
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}
}
