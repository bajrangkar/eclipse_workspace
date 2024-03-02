package mosh.executor.completablefuture;

public class CompletableFutureDemo04 {
			
	public static void main(String[] args) {
		
		var service = new MailService04();
		service.sendAsync();
		System.out.println("Hello World");
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
