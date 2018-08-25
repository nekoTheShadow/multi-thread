package chapter10;

public class Main {
	public static void main(String[] args) throws InterruptedException {
		System.out.println("main: BEGIN");
		var t = new CountupThread();
		t.start();
		
		Thread.sleep(1000 * 10);
		
		System.out.println("main: shutdownRequest");
		t.shutdownRequest();
		
		System.out.println("main: join");
		t.join();
		
		System.out.println("main: END");
	}
}
