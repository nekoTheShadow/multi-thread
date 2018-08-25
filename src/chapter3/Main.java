package chapter3;

import java.util.Random;

public class Main {
	public static void main(String[] args) throws InterruptedException {
		var random1 = new Random();
		var random2 = new Random();
		
		var queue = new RequestQueue();
		var alice = new ClientThread("Alice", queue, random1);
		var bobby = new ServerThread("Bobby", queue, random2);
		
		alice.start();
		bobby.start();
		
		Thread.sleep(10000);
		
		System.out.println("***** calling interrupt ****");
		alice.interrupt();
		bobby.interrupt();
	}
}
