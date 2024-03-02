package mosh.concurrency.race.adder;

import java.util.concurrent.atomic.LongAdder;

public class DownloadAdderStatus {
	private LongAdder totalBytes = new LongAdder();

	public int getTotalBytes() {
		return totalBytes.intValue();
	}
	
	public void incrementTotalBytes() {
		totalBytes.increment();
	}
}
