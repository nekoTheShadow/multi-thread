package chapter7;

public class Host {
	private final Helper helper = new Helper();
	public void request(final int count, final char c) {
		System.out.printf("request(%d, %c) BEGIN%n", count, c);
		new Thread() {
			public void run() {
				helper.handle(count, c);
			}
		}.start();
		System.out.printf("request(%d, %c) END%n", count, c);
	}
}
