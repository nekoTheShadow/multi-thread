package chapter10.excercise5;

public class Service {
	private static MyThread thread = null;
	
	public static synchronized void service() {
		System.out.print("service");
		if (thread != null && thread.isAlive()) {
			System.out.println(" is balked.");
			return ;
		}
		
		thread = new MyThread();
		thread.start();
	}
	
	public static synchronized void cancel() {
		if (thread != null) {
			System.out.println(" cancel.");
			thread.shutdownRequest();
		}
	}
	
//	public static void service() {
//		System.out.print("service");
//		for (int i = 0;i < 50; i++) {
//			System.out.print(".");
//			try {
//				Thread.sleep(100);
//			} catch (InterruptedException e) {
//				// PASS
//			}
//		}
//		System.out.println("done.");
//	}
//	
//	public static void cancel() {
//		
//	}
}
