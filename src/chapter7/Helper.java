package chapter7;

public class Helper {
	public void handle(int count, char c) {
		System.out.printf("handle(%d, %c) BEGIN%n", count, c);
		for (int i = 0; i < count; i++) {
			slowly();
			System.out.print(c);
		}
		System.out.println("");
		System.out.printf("handle(%d, %c) END%n", count, c);
	}

	private void slowly() {
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}
}
