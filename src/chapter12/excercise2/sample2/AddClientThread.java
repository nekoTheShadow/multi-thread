package chapter12.excercise2.sample2;

import java.util.concurrent.ExecutionException;

import chapter12.sample2.ActiveObject;

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
				var z = result.get();
				System.out.printf("%s: %s + %s = %s%n", Thread.currentThread().getName(), x, y, z);
				x = y;
				y = z;
			}
		} catch (InterruptedException | ExecutionException e) {
			throw new RuntimeException(e);
		}
	}
}
