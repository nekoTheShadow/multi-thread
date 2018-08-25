package chapter12.excercise2.sample1;

import chapter12.sample1.ActiveObjectFactory;

public class Main {
	public static void main(String[] args) {
		var activeObject = ActiveObjectFactory.createActiveObject();
		new AddClientThread("Diana", activeObject).start();
	}
}
