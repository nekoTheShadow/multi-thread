package chapter3.exerceise5;

import chapter3.Request;
import chapter3.RequestQueue;

public class Main {
	public static void main(String[] args) throws InterruptedException {
		var queue1 = new RequestQueue();
		var queue2 = new RequestQueue();
		queue1.putRequest(new Request("HELLO"));
		new TalkThread(queue1, queue2, "Alice").start();
		new TalkThread(queue2, queue1, "Bobby").start();
	}
}
