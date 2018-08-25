package chapter8;

import java.util.List;

public class Main {
	public static void main(String[] args) {
		var channel = new Channel(2);
		channel.startWorkers();
		
		var clientThreads = List.of(
			new ClientThread("Alice", channel),
			new ClientThread("Bobby", channel),
			new ClientThread("Chris", channel)
		);
		clientThreads.forEach(Thread::start);
	}
}
