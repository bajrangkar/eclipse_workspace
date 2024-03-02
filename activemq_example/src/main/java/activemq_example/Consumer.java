package activemq_example;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.ExceptionListener;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

public class Consumer {
	public static void main(String[] args) {
		thread(new HelloWorldConsumer(), false);
	}
	
	public static void thread(Runnable runnable, boolean daemon) {
		Thread brokerThread = new Thread(runnable);
		brokerThread.setDaemon(daemon);
		brokerThread.start();
	}
	
	public static class HelloWorldConsumer implements Runnable, ExceptionListener {
		public void run() {
			try {
				ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://0.0.0.0:61616");
				
				Connection connection = connectionFactory.createConnection();
				connection.start();
				connection.setExceptionListener(this);
				
				Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
				
				Destination destination = session.createQueue("message.queue");
				
				MessageConsumer consumer = session.createConsumer(destination);
				
				Message message = consumer.receive(1000);
				
				if(message instanceof TextMessage) {
					TextMessage textMessage =(TextMessage) message;
					String text = textMessage.getText();
					System.out.println("Received: " + text);
				} else {
					System.out.println("Received: " + message);
				}
				
				consumer.close();
				session.close();
				connection.close();
			} catch(Exception e) {
				System.out.println("Caught: "+e);
				e.printStackTrace();
			}
		}
		public synchronized void onException(JMSException ex) {
			System.out.println(" Exception Occurred. Client Shutdown.");
		}
	}
}
