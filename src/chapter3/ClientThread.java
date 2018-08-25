package chapter3;

import java.util.Random;

public class ClientThread extends Thread {
	private final Random random;
	private final RequestQueue queue;
	
	public ClientThread(String name, RequestQueue queue, Random random) {
		super(name);
		this.queue = queue;
		this.random = random;
	}
	
	public void run() {
		try {
			for (int i = 0; i < 10000; i++) {
				var request = new Request("No. " + i);
				System.out.printf("%s requests %s%n", Thread.currentThread().getName(), request);
				queue.putRequest(request);
				Thread.sleep(random.nextInt(1000));
			}
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}
}
