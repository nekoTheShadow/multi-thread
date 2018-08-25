package chapter8.excercise2;

import java.util.Random;

import chapter8.Request;

public class ClientThread extends Thread {
	private final Channel channel;
	public ClientThread(String name, Channel channel) {
		super(name);
		this.channel = channel;
	}
	
	public void run() {
		var random = new Random();
		for (int i = 0; ;i++) {
			var request = new Request(getName(), i);
			channel.putRequest(request);
			try {
				Thread.sleep(random.nextInt(1000));
			} catch (InterruptedException e) {
				new RuntimeException(e);
			}
		}
	}
}
