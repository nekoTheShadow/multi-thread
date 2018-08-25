package chapter3.exerceise5;

import chapter3.Request;
import chapter3.RequestQueue;

public class TalkThread extends Thread{
	private final RequestQueue input;
	private final RequestQueue output;
	
	public TalkThread(RequestQueue input, RequestQueue output, String name) {
		super(name);
		this.input = input;
		this.output = output;
	}
	
	public void run() {
		try {
			System.out.printf("%s :BEGIN%n", Thread.currentThread().getName());
			for (int i = 0; i < 20; i++) {
				var request1 = this.input.getRequest();
				System.out.printf("%s gets %s%n", Thread.currentThread().getName(), request1);
				
				var request2 = new Request(request1.getName() + "!");
				System.out.printf("%s puts %s%n", Thread.currentThread().getName(), request2);
				
				output.putRequest(request2);
			}
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		
		
	}
}
