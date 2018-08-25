package chapter9.excercise3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
	public static void main(String[] args) {
		var start = System.currentTimeMillis();
		
		var content1 = Retriever.retrieve("http://www.yahoo.com/");
		var content2 = Retriever.retrieve("http://www.google.com/");
		var content3 = Retriever.retrieve("http://www.hyuki.com/");
		
		saveToFile("yahoo.html", content1);
		saveToFile("google.html", content2);
		saveToFile("hyuki.html", content3);
		
		var end = System.currentTimeMillis();
		System.out.printf("Elapsed time = %d msec.%n", end - start);
	}
	
	private static void saveToFile(String filename, Content content) {
		byte[] bytes = content.getBytes();
		try (var out = Files.newOutputStream(Paths.get(filename))) {
			System.out.printf("%s :Saving to %s%n", Thread.currentThread().getName(), filename);
			out.write(bytes);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
