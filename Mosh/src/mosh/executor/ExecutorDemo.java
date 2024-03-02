package mosh.executor;

import java.util.concurrent.Executors;

public class ExecutorDemo {
	public static void show() {
		var executor = Executors.newFixedThreadPool(2);
		System.out.println(executor.getClass().getName());
	}
	public static void main(String[] args) {
		ExecutorDemo.show();
	}
}
