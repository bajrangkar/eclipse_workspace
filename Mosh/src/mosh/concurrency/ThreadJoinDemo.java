package mosh.concurrency;

public class ThreadJoinDemo {
	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getName());
		
		for (var i=0; i<10; i++) {
			Thread thread = new Thread(new DownloadFileTask());
			thread.start();
			
			try {
				thread.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			System.out.println("File is ready to be scanned." + Thread.currentThread().getName());
		}
		
		

	}
}
