package chapter7.excercise6;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Service {
	public static void service(final Socket clientSocket) {
		System.out.printf("%s: Service.service(%s) BEGIN%n", Thread.currentThread().getName(), clientSocket);
		try (var out = new DataOutputStream(clientSocket.getOutputStream())) {
			out.writeBytes("HTTP/1.0 200 OK\r\n");
			out.writeBytes("Content-type: text/html\r\n");
			out.writeBytes("\r\n");
			out.writeBytes("<html><head><title>Countdown</title></head><body>");
			out.writeBytes("<h1>Countdown start!</h1>");
			for (int i = 10; i >= 0; i--) {
				System.out.println(Thread.currentThread().getName() + ": Countdown i = " + i);
				out.writeBytes("<h1>" + i + "</h1>");
				out.flush();
				Thread.sleep(1000);
			}
			out.writeBytes("</body></html>");
		} catch (InterruptedException | IOException e) {
			throw new RuntimeException(e);
		}
		System.out.printf("%s: Service.service(%s) END%n", Thread.currentThread().getName(), clientSocket);	
	}
}
