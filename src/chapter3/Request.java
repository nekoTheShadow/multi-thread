package chapter3;

public class Request {
	private final String name;
	public Request(String name) {
		this.name = name;
	}
	public String getName() {
		return this.name;
	}
	public String toString() {
		return String.format("[ %s ]", this.name);
	}
}
