package chapter2.excercise3;

public class Main {
	private static final long CALL_COUNT = 1000000000L;
	public static void main(String[] args) {
		trial("NotSynch", CALL_COUNT, new NotSynch());
		trial("Synch", CALL_COUNT, new Synch());
	}
	public static void trial(String msg, long count, Object obj) {
		System.out.printf("%s: BEGIN%n", msg);
		var start = System.currentTimeMillis();
		for (long i = 0; i < count; i++) {
			obj.toString();
		}
		System.out.printf("%s: END%n", msg);
		System.out.printf("Elapsed time = %d msec.%n", System.currentTimeMillis() - start);
	}
	
	private static class NotSynch {
		private final String name = "NotSynch";
		public String toString() {
			return String.format("[ %s ]", this.name);
		}
	}
	
	private static class Synch {
		private final String name = "Synch";
		public String toString() {
			return String.format("[ %s ]", this.name);
		}
	}
}
