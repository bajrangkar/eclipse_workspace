package mosh.executor.completablefuture;

import java.util.concurrent.CompletableFuture;

import mosh.executor.LongTask;

public class MailService04 {
	public void send() {
		LongTask.simulate();
		System.out.println("Mail was sent.");
	}
	
	public CompletableFuture<Void> sendAsync() {
		return CompletableFuture.runAsync(() -> send());
	}
}
