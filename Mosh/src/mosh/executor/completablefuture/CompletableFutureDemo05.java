package mosh.executor.completablefuture;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureDemo05 {
	
	public static void show() {
		var future = CompletableFuture.supplyAsync(() -> 1);
		future.thenAcceptAsync(result -> {
			System.out.println(Thread.currentThread().getName());
			System.out.println(result);			
		});
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
			
	public static void main(String[] args) {
		CompletableFutureDemo05.show();
	}
}

/*
future.thenRun(() -> {
	System.out.println(Thread.currentThread().getName());
	System.out.println("Done");			
});

future.thenRunAsync(() -> {
	System.out.println(Thread.currentThread().getName());
	System.out.println("Done");			
});

future.thenAccept(result -> {
	System.out.println(Thread.currentThread().getName());
	System.out.println(result);			
});

future.thenAcceptAsync(result -> {
	System.out.println(Thread.currentThread().getName());
	System.out.println(result);			
});

*/