package chapter6;

import java.util.List;

public class Main {
	public static void main(String[] args) {
		var data = new Data(10);
		var threads = List.of(
			new ReaderThread(data),
			new ReaderThread(data),
			new ReaderThread(data),
			new ReaderThread(data),
			new ReaderThread(data),
			new ReaderThread(data),
			new WriterThread(data, "ABCDEFGHIJKLMNOPQRSTUVWXYZ"),
			new WriterThread(data, "abcdefghijklmnopqrstuvwxyz")
		);
		threads.forEach(Thread::start);
	}
}
