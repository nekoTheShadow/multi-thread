package chapter9.excercise3;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.URL;

public class SyncContentImpl implements Content {
	private byte[] contentbytes;
	
	public SyncContentImpl(String url) {
		System.out.printf("%s: Getting %s%n", Thread.currentThread().getName(), url);
		try (var in = new DataInputStream(new URL(url).openStream())) {
			contentbytes = in.readAllBytes();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	@Override
	public byte[] getBytes() {
		return contentbytes;
	}
}
