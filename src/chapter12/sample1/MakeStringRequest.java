package chapter12.sample1;

public class MakeStringRequest extends MethodRequest<String> {
	private final int count;
	private final char fillchar;
	
	public MakeStringRequest(Servant servant, FutureResult<String> future, int count, char fillchar) {
		super(servant, future);
		this.count = count;
		this.fillchar = fillchar;
	}

	@Override
	public void execute() {
		var result = servant.makeString(count, fillchar);
		future.setResult(result);
	}
}
