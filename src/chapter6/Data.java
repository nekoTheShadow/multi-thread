package chapter6;

import java.util.Arrays;

public class Data {
	private final char[] buffer;
	private final ReadWriteLock lock = new ReadWriteLock();
	
	public Data(int size) {
		this.buffer = new char[size];
		Arrays.fill(this.buffer, '*');
	}
	
	public char[] read() throws InterruptedException {
		lock.readLock();
		try {
			return doRead();
		} finally {
			lock.readUnlock();
		}
	}

	private char[] doRead() {
		var len = buffer.length;
		var newBuf = new char[len];
		for (int i = 0; i < len; i++) {
			newBuf[i] = buffer[i];
		}
		slowly();
		return newBuf;
	}
	
	public void write(char c) throws InterruptedException {
		lock.writeLock();
		try {
			doWrite(c);
		} finally {
			lock.writeUnlock();
		}
	}
	
	private void doWrite(char c) {
		for (int i = 0; i < buffer.length; i++) {
			buffer[i] = c;
			slowly();
		}
	}

	private void slowly() {
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			// PASS
		}
	}
}
