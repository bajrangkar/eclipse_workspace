package mosh.executor;

import java.util.concurrent.Executors;

public class ExecutorDemo02 {
	public static void show() {
		var executor = Executors.newFixedThreadPool(2);
		for(var i=0; i<10; i++)
			executor.submit(() -> {
				System.out.println(Thread.currentThread().getName());
			});
		executor.shutdown();
	}
	public static void main(String[] args) {
		ExecutorDemo02.show();
	}
}
