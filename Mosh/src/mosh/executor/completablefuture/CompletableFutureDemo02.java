package mosh.executor.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Supplier;

public class CompletableFutureDemo02 {
	public static void show() {
		Supplier<Integer> task = () -> 1;
		var future = CompletableFuture.supplyAsync(task);
		
		try {
			var result = future.get();
			System.out.println(result);
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		
	}
			
	public static void main(String[] args) {
		CompletableFutureDemo02.show();
	}
}
