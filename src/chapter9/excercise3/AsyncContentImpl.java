package chapter9.excercise3;

import java.io.DataInputStream;
import java.net.URL;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class AsyncContentImpl implements Content {
	private FutureTask<byte[]> future;
	
	public AsyncContentImpl(String url) {
		System.out.printf("%s: Getting %s%n", Thread.currentThread().getName(), url);
		future = new FutureTask<>(() -> {
			try (var in = new DataInputStream(new URL(url).openStream())) {
				return in.readAllBytes();
			}
		});
		var thread = new Thread(future);
		thread.start();
	}
	
	@Override
	public byte[] getBytes() {
		try {
			return future.get();
		} catch (InterruptedException | ExecutionException e) {
			throw new RuntimeException(e);
		}
	}
}
