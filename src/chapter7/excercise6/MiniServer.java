package chapter7.excercise6;

import java.io.IOException;
import java.net.ServerSocket;

public class MiniServer {
	private final int portnumber;
	public MiniServer(int portnumber) {
		this.portnumber = portnumber;
	}
	public void execute() throws IOException {
		try (var serverSocket = new ServerSocket(portnumber)) {
			System.out.println("Listening on " + serverSocket);
			while (true) {
				System.out.println("Accepting...");
				var clientSocket = serverSocket.accept();
				System.out.println("Connected to " + clientSocket);
				new Thread(() -> Service.service(clientSocket)).start();
			}
		}
	}
}