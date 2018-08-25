package chapter1.excercise6;

public class EaterThread extends Thread {
	private String name;
	private final Tool lefthand;
	private final Tool righthand;
	public EaterThread(String name, Tool lefthand, Tool righthand) {
		this.name = name;
		this.lefthand = lefthand;
		this.righthand = righthand;
	}
	
	public void run() {
		while (true) {
			eat();
		}
	}

	private void eat() {
		synchronized (lefthand) {
			System.out.printf("%s takes up %s (left).%n", this.name, this.lefthand);
			synchronized (righthand) {
				System.out.printf("%s takes up %s (right).%n", this.name, this.righthand);
				System.out.printf("%s is eating now, yum yum!%n", this.name);
				System.out.printf("%s puts down %s (right).%n", this.name, this.righthand);
			}
			System.out.printf("%s puts up %s (left).%n", this.name, this.lefthand);
		}
	}
}
