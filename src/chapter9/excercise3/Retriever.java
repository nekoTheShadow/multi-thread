package chapter9.excercise3;

public class Retriever {
	public static Content retrieve(String url) {
//		return new SyncContentImpl(url);
		return new AsyncContentImpl(url);
	}
}
