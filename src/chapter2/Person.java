package chapter2;

public class Person {
	private final String name;
	private final String address;
	
	public Person(String name, String address) {
		this.name = name;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	@Override
	public String toString() {
		return String.format("[ Person: name = %s, address = %s ]", this.name, this.address);
	}
	
}
