package chapter12.sample2;

public class Main {
	public static void main(String[] args) {
		var activeObject = ActiveObjectFactory.createActiveObject();
		try {
			new MakerClientThread("Alice", activeObject).start();
			new MakerClientThread("Bobby", activeObject).start();
			new DisplayClientThread("Chris", activeObject).start();
			Thread.sleep(5 * 1000);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		} finally {
			activeObject.shutdown();
		}
	}
}
