package chapter1;

public class Gate {
	private int counter = 0;
	private String name ="Nobody";
	private String address = "Nowhere";
	
	public synchronized void pass(String name, String address) {
		this.counter++;
		this.name = name;
		this.address = address;
		check();
	}
	
	@Override
	public synchronized String toString() {
		return String.format("No.%d: %s, %s", this.counter, this.name, this.address);
	}

	private void check() {
		if (this.name.charAt(0) != this.address.charAt(0)) {
			System.out.println("***** BROKEN ***** " + this.toString());
		}
	}
}
