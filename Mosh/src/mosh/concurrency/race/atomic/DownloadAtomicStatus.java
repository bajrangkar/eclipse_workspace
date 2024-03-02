package mosh.concurrency.race.atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class DownloadAtomicStatus {
	private AtomicInteger totalBytes = new AtomicInteger();

	public int getTotalBytes() {
		return totalBytes.get();
	}
	
	public void incrementTotalBytes() {
		totalBytes.incrementAndGet();
	}
}
