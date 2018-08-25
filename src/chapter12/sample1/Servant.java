package chapter12.sample1;

import java.math.BigInteger;

public class Servant implements ActiveObject {
	@Override
	public Result<String> makeString(int count, char fillchar) {
		var buffer = new char[count];
		for (int i = 0; i < count; i++) {
			buffer[i] = fillchar;
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		}
		return new RealResult<String>(new String(buffer));
	}

	@Override
	public void displayString(String string) {
		try {
			System.out.printf("displayString: %s%n", string);
			Thread.sleep(10);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public Result<String> add(String x, String y) {
		var bigX = new BigInteger(x);
		var bigY = new BigInteger(y);
		return new RealResult<String>(bigX.add(bigY).toString());
	}
	
}
