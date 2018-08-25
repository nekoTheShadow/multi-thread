package chapter12.excercise2.sample1;

import chapter12.sample1.ActiveObject;

public class AddClientThread extends Thread {
	private final ActiveObject activeObject;
	private String x = "1";
	private String y = "1";
	
	public AddClientThread(String name, ActiveObject activeObject) {
		super(name);
		this.activeObject = activeObject;
	}
	
	public void run() {
		try {
			while(true) {
				var result = activeObject.add(x, y);
				Thread.sleep(100);
				var z = result.getResultValue();
				System.out.printf("%s: %s + %s = %s%n", Thread.currentThread().getName(), x, y, z);
				x = y;
				y = z;
			}
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}
}
