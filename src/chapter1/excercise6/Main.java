package chapter1.excercise6;

public class Main {
	public static void main(String[] args) {
		System.out.println("Testing EaterThread, hit CTRL+C to exit.");
		var spoon = new Tool("Spoon");
		var fork = new Tool("Fork");
		// new EaterThread("Alice", spoon, fork).start();
		// new EaterThread("Bobby", fork, spoon).start();
		// ↑ Example
		// ↓ Dead Lock 回避
		new EaterThread("Alice", fork, spoon).start();
		new EaterThread("Bobby", fork, spoon).start();
	}
}
