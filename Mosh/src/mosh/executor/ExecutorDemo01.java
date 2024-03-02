package mosh.executor;

import java.util.concurrent.Executors;

public class ExecutorDemo01 {
	public static void show() {
		var executor = Executors.newFixedThreadPool(2);
		executor.submit(() -> {
			System.out.println(Thread.currentThread().getName());
		});
	}
	public static void main(String[] args) {
		ExecutorDemo01.show();
	}
}
