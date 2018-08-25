package chapter5;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class Table {
	private final Queue<String> buffer = new LinkedBlockingQueue<>();
	private int count;
	
	public Table(int count) {
		this.count = count;
	}
	
	public synchronized void put(String cake) throws InterruptedException {
		System.out.printf("%s puts %s%n", Thread.currentThread().getName(), cake);
		while (count <= buffer.size()) {
			System.out.printf("%s waits, at Table::put.%n", Thread.currentThread().getName());
			wait();
		}
		buffer.add(cake);
		notifyAll();
	}
	
	public synchronized String take() throws InterruptedException {
		while (buffer.isEmpty()) {
			System.out.printf("%s waits, at Table::take.%n", Thread.currentThread().getName());
			wait();
		}
		
		var cake = buffer.remove();
		notifyAll();
		System.out.printf("%s takes %s%n", Thread.currentThread().getName(), cake);
		return cake;
	}
	
	public synchronized void clear() {
		buffer.clear();
		notifyAll();
	}
}
