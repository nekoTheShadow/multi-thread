package chapter9;

public class Host {
	public Data request(final int count, final char c) {
		System.out.printf("request(%d, %c) BEGIN%n", count, c);
		
		final FutureData future = new FutureData();
		new Thread(() -> {
			var realData = new RealData(count, c);
			future.setRealData(realData);
		}).start();
		
		System.out.printf("request(%d, %c) END%n", count, c);
		return future;
	}
}
