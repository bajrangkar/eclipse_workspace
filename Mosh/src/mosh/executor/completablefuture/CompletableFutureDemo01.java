package mosh.executor.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureDemo01 {
	public static void show() {
		Runnable task = () -> System.out.println("a");
		var future = CompletableFuture.runAsync(task);
		
		try {
			var result = future.get();
			System.out.println(result);
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		
	}
			
	public static void main(String[] args) {
		CompletableFutureDemo01.show();
	}
}
