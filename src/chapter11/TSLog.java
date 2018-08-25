package chapter11;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class TSLog {
	private PrintWriter writer;
	
	public TSLog(String filename) {
		try {
			writer = new PrintWriter(new FileWriter(filename));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void println(String s) {
		writer.println(s);
	}
	
	public void close() {
		writer.println("==== End of Log ====");
		writer.close();
	}
}
 