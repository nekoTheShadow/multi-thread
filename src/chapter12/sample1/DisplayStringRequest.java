package chapter12.sample1;

public class DisplayStringRequest<T> extends MethodRequest<T> {
	private final String string;

	protected DisplayStringRequest(Servant servant, String string) {
		super(servant, null);
		this.string = string;
	}

	@Override
	public void execute() {
		servant.displayString(string);
	}
}
