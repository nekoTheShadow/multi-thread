package chapter2;

public class PrintPersonThread extends Thread {
	private Person person;
	public PrintPersonThread(Person person) {
		this.person = person;
	}
	
	@Override
	public void run() {
		while (true) {
			System.out.printf("%s prints %s%n", Thread.currentThread().getName(), person);
		}
	}
}
