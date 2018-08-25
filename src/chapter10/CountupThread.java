package chapter10;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class CountupThread extends GracefulThread {
	private long counter = 0;
	
	public void doWork() throws InterruptedException {
		counter++;
		System.out.println("doWork: counter = " + counter);
		Thread.sleep(500);
	}
	
	public void doShutdown() {
		System.out.println("doShutdown: counter = " + counter);
		try {
			Files.write(Paths.get("counter.txt"), Arrays.asList(String.valueOf(this.counter)));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
