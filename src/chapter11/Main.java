package chapter11;

public class Main {
	public static void main(String[] args) throws InterruptedException {
		new ClientThread("Alice").start();
		new ClientThread("Bobby").start();
		new ClientThread("Chris").start();
	}
}
