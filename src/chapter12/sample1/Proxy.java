package chapter12.sample1;

public class Proxy implements ActiveObject {
	private final SchedulerThread<String> scheduler;
	private final Servant servant;
	
	public Proxy(SchedulerThread<String> scheduler, Servant servant) {
		this.scheduler = scheduler;
		this.servant = servant;
	}

	@Override
	public Result<String> makeString(int count, char fillchar) {
		var future = new FutureResult<String>();
		scheduler.invoke(new MakeStringRequest(servant, future, count, fillchar));
		return future;
	}

	@Override
	public void displayString(String string) {
		scheduler.invoke(new DisplayStringRequest<String>(servant, string));
	}

	@Override
	public Result<String> add(String x, String y) {
		var future = new FutureResult<String>();
		scheduler.invoke(new AddRequest(servant, future, x, y));
		return future;
	}
}
