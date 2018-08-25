package chapter8;

import java.util.Random;

public class Request {
	private final String name;
	private final int number;
	private static final Random random = new Random();
	
	public Request(String name, int number) {
		this.name = name;
		this.number = number;
	}
	
	public void execute() {
		System.out.printf("%s executes %s%n", Thread.currentThread().getName(), this);
		try {
			Thread.sleep(random.nextInt(1000));
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}
	
	public String toString() {
		return String.format("[ Request from %s No. %d ]", name, number);
	}
}
