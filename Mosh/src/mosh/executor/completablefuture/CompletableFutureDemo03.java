package mosh.executor.completablefuture;

public class CompletableFutureDemo03 {
			
	public static void main(String[] args) {
		
		var service = new MailService03();
		service.send();
		System.out.println("Hello World");
	}
}
