package chapter8.excercise2;

import chapter8.Request;

public class Channel {
	public void putRequest(Request request) {
		new Thread(() -> request.execute()).start();
	}
}
 