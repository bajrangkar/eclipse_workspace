package mosh.concurrency.race;

import java.util.ArrayList;
import java.util.List;

public class ThreadRaceDemo {
	public static void main(String[] args) {
		var status = new DownloadStatus();
		
		List<Thread> threads = new ArrayList<>();
		
		for (var i=0; i<10; i++) {
			Thread thread = new Thread(new DownloadFileRaceTask(status));
			thread.start();
			threads.add(thread);
		}
		
		for(var thread : threads) {
			try {
				thread.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println(status.getTotalBytes());
	}
	
}
