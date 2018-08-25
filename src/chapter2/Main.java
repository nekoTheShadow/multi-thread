package chapter2;

public class Main {
	public static void main(String[] args) {
		var alice = new Person("Alice", "Alaska");
		new PrintPersonThread(alice).start();
		new PrintPersonThread(alice).start();
		new PrintPersonThread(alice).start();
	}
}
