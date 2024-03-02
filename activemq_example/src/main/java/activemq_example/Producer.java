package activemq_example;

import javax.jms.Connection;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;


public class Producer {
	
	public static void main(String[] args) {
		thread(new HelloWorldProducer(), false);
	}
	
	public static void thread(Runnable runnable, boolean daemon) {
		Thread brokerThread = new Thread(runnable);
		brokerThread.setDaemon(daemon);
		brokerThread.start();
	}
	
	public static class HelloWorldProducer implements Runnable {
		public void run() {
			try {
				ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://0.0.0.0:61616");
				
				Connection connection = connectionFactory.createConnection();
				connection.start();
				
				Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
				
				Destination destination = session.createQueue("message.queue");
				
				MessageProducer producer = session.createProducer(destination);
				producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
				
				String text = "Hello world! From: " + Thread.currentThread().getName() + " : " + this.hashCode();
				TextMessage message = session.createTextMessage(text);
				
				System.out.println("Sent message: " + message.hashCode() + " : " + Thread.currentThread().getName());
				producer.send(message);
				
				session.close();
				connection.close();
			} catch(Exception e) {
				System.out.println("Caught: "+e);
				e.printStackTrace();
			}
		}
	}
}
