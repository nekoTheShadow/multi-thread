package chapter12.sample2;

import java.util.concurrent.ExecutionException;

public class MakerClientThread extends Thread {
	private final ActiveObject activeObject;
	private final char fillchar;
	
	public MakerClientThread(String name, ActiveObject activeObject) {
		super(name);
		this.activeObject = activeObject;
		this.fillchar = name.charAt(0);
	}
	
	@Override
	public void run() {
		try {
			for (int i = 0; ; i++) {
				var future = activeObject.makeString(i, fillchar);
				Thread.sleep(10);
				var value = future.get();
				System.out.printf("%s: value = %s%n", Thread.currentThread().getName(), value);
			}
		} catch (InterruptedException | ExecutionException e) {
			throw new RuntimeException(e);
		}
	}
}
