package chapter1.excercise6;

public class Tool {
	private final String name;
	public Tool(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return String.format("[ %s ]", this.name);
	}
}
