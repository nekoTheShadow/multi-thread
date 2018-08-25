package chapter4;

public class Main {
	public static void main(String[] args) {
		var data = new Data("data.txt", "(empty)");
		new ChangerThread("ChangedThread", data).start();
		new SaverThread("SaverThread", data).start();
	}
}
