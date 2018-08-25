package chapter8.excercise2;

public class Main {
	public static void main(String[] args) {
		var channel = new Channel();
		new ClientThread("Alice", channel).start();
		new ClientThread("Bobby", channel).start();
		new ClientThread("Chris", channel).start();
	}
}
