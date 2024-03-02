package mosh.concurrency;

public class ThreadInterruptDemo {
	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getName());
		
		Thread thread = new Thread(new DownloadFileInterruptTask());
		thread.start();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		thread.interrupt();
	}
	
}
