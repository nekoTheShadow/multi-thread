package chapter5;

import java.util.Random;

public class EaterThread extends Thread {
	private final Random random;
	private final Table table;
	public EaterThread(String name, Table table, Random random) {
		super(name);
		this.table = table;
		this.random = random;
	}
	
	public void run() {
		try {
			while (true) {
				var cake = table.take();
				Thread.sleep(random.nextInt(1000));
			}
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}
}
