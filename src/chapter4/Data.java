package chapter4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Data {
	private final String filename;
	private String content;
	private boolean changed;
	
	public Data(String filename, String content) {
		this.filename = filename;
		this.content = content;
	}
	
	public synchronized void change(String newContent) {
		this.content = newContent;
		this.changed = true;
	}
	
	public synchronized void save() throws IOException {
		if (!this.changed) {
			System.out.printf("%s balks.%n", Thread.currentThread().getName());
			return ;
		}
		doSave();
		this.changed = false;
	}
	
	private void doSave() throws IOException {
		System.out.printf("%s calls doSave, content = %s%n", Thread.currentThread().getName(), this.content);
		try (var writer = Files.newBufferedWriter(Paths.get(this.filename))) {
			writer.write(this.content);
		}
	}
}
