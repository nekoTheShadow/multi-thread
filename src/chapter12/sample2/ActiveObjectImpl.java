package chapter12.sample2;

import java.math.BigInteger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ActiveObjectImpl implements ActiveObject {
	private final ExecutorService service = Executors.newSingleThreadExecutor();
	

	@Override
	public Future<String> makeString(final int count, final char fillchar) {
		return service.submit(() -> {
			var buffer = new char[count];
			for (int i = 0; i < count; i++) {
				buffer[i] = fillchar;
				Thread.sleep(100);
			}
			return new String(buffer);
		});
	}

	@Override
	public void displayString(final String string) {
		service.submit(() -> {
			try {
				System.out.printf("displayString: %s%n", string);
				Thread.sleep(10);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		});
	}

	@Override
	public void shutdown() {
		service.shutdown();
	}

	@Override
	public Future<String> add(String x, String y) {
		return service.submit(() -> {
			var bigX = new BigInteger(x);
			var bigY = new BigInteger(y);
			var bigZ = bigX.add(bigY);
			return bigZ.toString();
		});
	}
}
