package mosh.executor;

import java.util.concurrent.Executors;

public class ExecutorDemo03 {
	public static void show() {
		var executor = Executors.newFixedThreadPool(2);
		try {
			executor.submit(() -> {
				System.out.println(Thread.currentThread().getName());
			});
		} 
		finally {
			executor.shutdown();
		}
	}
			
	public static void main(String[] args) {
		ExecutorDemo03.show();
	}
}
