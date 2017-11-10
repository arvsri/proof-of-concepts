package self.poc;

import java.util.concurrent.CountDownLatch;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import self.poc.client.RetryableWebSocketConnectionManager;

public class EchoClient {

	public static void main(String[] args) throws InterruptedException {
		ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
		RetryableWebSocketConnectionManager connectionManager = context.getBean("webSocketConnectionManager", RetryableWebSocketConnectionManager.class);
		connectionManager.startWithRetry();
		//connectionManager.start();
		System.out.println("Connection Manager status : " + connectionManager.isRunning());		
		
		new CountDownLatch(1).await();
	}

}
