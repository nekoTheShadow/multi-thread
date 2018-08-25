package chapter7.excercise4;

import chapter7.Helper;

public class HelperThread extends Thread {
	private final Helper helper = new Helper();
	
	private final int count;
	private final char c;
	
	public HelperThread(int count, char c) {
		this.count = count;
		this.c = c;
	}
	
	public void run() {
		helper.handle(count, c);
	}
}
