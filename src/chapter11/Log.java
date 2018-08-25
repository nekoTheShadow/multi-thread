package chapter11;

public class Log {
	private static final ThreadLocal<TSLog> tsLogCollection = new ThreadLocal<>();

	public static void println(String s) {
		getTSLog().println(s);
	}
	
	public static void close() {
		getTSLog().close();
	}
	
	private static TSLog getTSLog() {
		var tsLog = tsLogCollection.get();
		if (tsLog == null) {
			tsLog = new TSLog(Thread.currentThread().getName() + "-log.txt");
			tsLogCollection.set(tsLog);
			startWatcher(tsLog);
		}
		return tsLog;
	}
	
	private static void startWatcher(final TSLog tsLog) {
		final Thread target = Thread.currentThread();
		final Thread watcher = new Thread() {
			public void run() {
				System.out.printf("startWatcher for %s BEGIN%n", target.getName());
				try {
					target.join();
				} catch (InterruptedException e) {
					throw new RuntimeException(e);
				}
				tsLog.close();
				System.out.printf("startWatcher for %s END%n", target.getName());
			}
		};
		watcher.start();
	}
}
