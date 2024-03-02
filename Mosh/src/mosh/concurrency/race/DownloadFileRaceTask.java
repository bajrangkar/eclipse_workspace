package mosh.concurrency.race;

public class DownloadFileRaceTask implements Runnable {
	private DownloadStatus status;

	public DownloadFileRaceTask(DownloadStatus status) {
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
