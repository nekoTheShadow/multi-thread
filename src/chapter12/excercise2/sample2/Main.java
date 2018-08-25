package chapter12.excercise2.sample2;

import chapter12.sample2.ActiveObjectFactory;

public class Main {
	public static void main(String[] args) {
		var activeObject = ActiveObjectFactory.createActiveObject();
		new AddClientThread("Diana", activeObject).start();
	}
}
