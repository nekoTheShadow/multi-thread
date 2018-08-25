package chapter12.sample1;

public class Main {
	public static void main(String[] args) {
		var activeObject = ActiveObjectFactory.createActiveObject();
		new MakerClientThread("Alice", activeObject).start();
		new MakerClientThread("Bobby", activeObject).start();
		new DisplayClientThread("Chris", activeObject).start();
	}
}
