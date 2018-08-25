package chapter7.excercise7;

public class Main {
	public static void main(String[] args) {
		System.out.println("BEGIN");
		var obj = new Object();
		Blackhole.enter(obj);
		System.out.println("END");
	}
}
