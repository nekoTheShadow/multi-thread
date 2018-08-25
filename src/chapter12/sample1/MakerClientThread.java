package chapter12.sample1;

public class MakerClientThread extends Thread {
	private final ActiveObject activeObject;
	private final char fillchar;
	
	public MakerClientThread(String name, ActiveObject activeObject) {
		super(name);
		this.activeObject = activeObject;
		this.fillchar = name.charAt(0);
	}
	
	public void run() {
		try {
			for (int i = 0; ; i++) {
				var result = activeObject.makeString(i, fillchar);
				Thread.sleep(10);
				var value = result.getResultValue();
				System.out.printf("%s : value = %s%n", Thread.currentThread().getName(), value);
			}
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}
}
