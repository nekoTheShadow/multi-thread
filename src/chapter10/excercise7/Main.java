package chapter10.excercise7;

public class Main {
	public static void main(String[] args) throws InterruptedException {
		var t = new HanoiThread();
		t.start();
		
		Thread.sleep(1000 * 10);
		
		System.out.println("main:shutdownRequest");
		t.shutdownRequest();
		
		System.out.println("main:join");
		t.join();
		System.out.println("main:END");
	}
}
