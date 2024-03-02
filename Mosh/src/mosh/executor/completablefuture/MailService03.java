package mosh.executor.completablefuture;

import mosh.executor.LongTask;

public class MailService03 {
	public void send() {
		LongTask.simulate();
		System.out.println("Mail was sent.");
	}
}
