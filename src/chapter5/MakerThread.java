package chapter5;

import java.util.Random;

public class MakerThread extends Thread {
	private final Random random;
	private final Table table;
	
	public MakerThread(String name, Table table, Random random) {
		super(name);
		this.table = table;
		this.random = random;
	}
	
	public void run() {
		try {
			while (true) {
				Thread.sleep(random.nextInt(1000));
				var cake = String.format("[ Cake No. %d by %s ]", nextId(), getName());
				table.put(cake);
			}
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}
	
	private static int id = 0;
	private static synchronized int nextId() {
		return id++;
	}
}
