package chapter12.sample1;

public class ActiveObjectFactory {
	public static ActiveObject createActiveObject() {
		var servant = new Servant();
		var queue = new ActivationQueue<String>();
		var scheduler = new SchedulerThread<String>(queue);
		var proxy = new Proxy(scheduler, servant);
		scheduler.start();
		return proxy;
	}
}
