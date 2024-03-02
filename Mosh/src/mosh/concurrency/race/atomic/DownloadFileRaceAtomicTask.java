package mosh.concurrency.race.atomic;

public class DownloadFileRaceAtomicTask implements Runnable {
	private DownloadAtomicStatus status;

	public DownloadFileRaceAtomicTask(DownloadAtomicStatus status) {
		this.status = status;
	}

	@Override
	public void run() {
		System.out.println("Downloading a file : " + Thread.currentThread().getName());	
		
		for(var i = 0; i < 10_000; i++) {
			if(Thread.currentThread().isInterrupted()) return;
			status.incrementTotalBytes();
		}
		
		System.out.println("Download complete : " + Thread.currentThread().getName());	
		
	}
}
