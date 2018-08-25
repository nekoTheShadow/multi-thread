package chapter12.sample2;

import java.util.concurrent.Future;

public interface ActiveObject {
	Future<String> makeString(int count, char fillchar);
	void displayString(String string);
	void shutdown();
	Future<String> add(String x, String y);
}
