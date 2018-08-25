package chapter6.excercise4;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Database<K, V> {
	private final ReadWriteLock readWriterLock = new ReentrantReadWriteLock(true);
	private final Lock readLock = readWriterLock.readLock();
	private final Lock writeLock = readWriterLock.writeLock();
	
	private final Map<K, V> map = new HashMap<>();
	
	public synchronized void clear() {
		writeLock.lock();
		try {
			verySlowly();
			map.clear();
		} finally {
			writeLock.unlock();
		}	
	}
	
	public synchronized void assign(K key, V value) {
		writeLock.lock();
		try {
			verySlowly();
			map.put(key, value);
		} finally {
			writeLock.unlock();
		}
	}
	
	public synchronized V retrieve(K key) {
		readLock.lock();
		try {
			slowly();
			return map.get(key);
		} finally {
			readLock.unlock();
		}
	}

	private void slowly() {
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			// PASS
		}
	}
	
	private void verySlowly() {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// PASS
		}
	}
}
