package mosh.concurrency.race.adder;

import java.util.ArrayList;
import java.util.List;

public class ThreadRaceAdderDemo {
	public static void main(String[] args) {
		var status = new DownloadAdderStatus();
		
		List<Thread> threads = new ArrayList<>();
		
		for (var i=0; i<10; i++) {
			Thread thread = new Thread(new DownloadFileRaceAdderTask(status));
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
