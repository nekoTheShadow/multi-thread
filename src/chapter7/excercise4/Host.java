package chapter7.excercise4;

public class Host {
	public void request(final int count, final char c) {
		System.out.printf("request(%d, %c) BEGIN%n", count, c);
		new HelperThread(count, c).start();
		System.out.printf("request(%d, %c) END%n", count, c);
	}
}
