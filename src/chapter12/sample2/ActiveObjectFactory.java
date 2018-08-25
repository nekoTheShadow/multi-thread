package chapter12.sample2;

public class ActiveObjectFactory {
	public static ActiveObject createActiveObject() {
		return new ActiveObjectImpl();
	}
}
