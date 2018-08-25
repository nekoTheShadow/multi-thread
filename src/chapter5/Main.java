package chapter5;

import java.util.List;
import java.util.Random;

public class Main {
	public static void main(String[] args) throws InterruptedException {
		var table = new Table(3);
		var m1 = new MakerThread("MakerThread-1", table, new Random());
		var m2 = new MakerThread("MakerThread-2", table, new Random());
		var m3 = new MakerThread("MakerThread-3", table, new Random());
		var e1 = new EaterThread("EaterThread-1", table, new Random());
		var e2 = new EaterThread("EaterThread-2", table, new Random());
		var e3 = new EaterThread("EaterThread-3", table, new Random());
		
		var threads = List.of(m1, m2, m3, e1, e2, e3);
		threads.forEach(Thread::start);
		Thread.sleep(1000 * 10);
		threads.forEach(Thread::interrupt);
	}
}
