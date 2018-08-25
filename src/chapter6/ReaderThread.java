package chapter6;


public class ReaderThread extends Thread {
	private final Data data;
	public ReaderThread(Data data) {
		this.data = data;
	}
	public void run() {
		try {
			while (true) {
				var readBuf = data.read();
				System.out.printf("%s reads %s%n", Thread.currentThread().getName(), String.valueOf(readBuf));
			}
		} catch (InterruptedException e) {
			// PASS
		}
	}
}
