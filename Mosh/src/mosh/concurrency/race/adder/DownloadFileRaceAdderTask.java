package mosh.concurrency.race.adder;

public class DownloadFileRaceAdderTask implements Runnable {
	private DownloadAdderStatus status;

	public DownloadFileRaceAdderTask(DownloadAdderStatus status) {
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
