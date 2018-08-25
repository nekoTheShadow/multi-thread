package chapter5.excercise7;

public class Host {
	public static void main(String[] args) throws InterruptedException {
		var thread = new Thread() {
			public void run() {
				execute(10);
			}
		};
		thread.start();
		Thread.sleep(30 * 1000);
		thread.interrupt();
	}
	
	public static void execute(int count) {
		for (int i = 0; i < count; i++) {
			if (Thread.interrupted()) {
				throw new RuntimeException("interuppted");
			}
			doHeavyJob();
		}
	}
 	
	
	private static void doHeavyJob() {
		System.out.println("doHeavyJob BEGIN");
		var start = System.currentTimeMillis();
		while (start + 1000 * 10 > System.currentTimeMillis()) {
			// PASS
		}
		System.out.println("doHeavyJob END");
	}
}
