package chapter9;

public class RealData implements Data {
	private final String content;
	
	@Override
	public String getContent() {
		return content;
	}
	
	public RealData(int count, char c) {
		System.out.printf("making RealData(%d,%c) BEGIN%n", count, c);
		var buffer = new char[count];
		for (int i = 0; i < count; i++) {
			buffer[i] = c;
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		}
		System.out.printf("making RealData(%d,%c) END%n", count, c);
		this.content = new String(buffer);
	}

}
