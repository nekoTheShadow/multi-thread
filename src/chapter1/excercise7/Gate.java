package chapter1.excercise7;

public class Gate {
	private int counter = 0;
	private String name ="Nobody";
	private String address = "Nowhere";
	private final Mutex mutex = new Mutex();
	
	public void pass(String name, String address) {
		mutex.lock();
		try {
			this.counter++;
			this.name = name;
			this.address = address;
			check();			
		} finally {
			mutex.unlock();
		}
	}
	
	@Override
	public String toString() {
		mutex.lock();
		try {
			return String.format("No.%d: %s, %s", this.counter, this.name, this.address);
		} finally {
			mutex.unlock();
		}
	}

	private void check() {
		if (this.name.charAt(0) != this.address.charAt(0)) {
			System.out.println("***** BROKEN ***** " + this.toString());
		}
	}
}
