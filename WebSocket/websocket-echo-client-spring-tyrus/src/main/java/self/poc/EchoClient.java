package self.poc;

import java.util.concurrent.CountDownLatch;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.socket.client.WebSocketConnectionManager;

public class EchoClient {

	public static void main(String[] args) throws InterruptedException {
		ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
		WebSocketConnectionManager connectionManager = context.getBean("webSocketConnectionManager", WebSocketConnectionManager.class);
		System.out.println("Connection Manager status : " + connectionManager.isRunning());		
		
		new CountDownLatch(1).await();
	}

}
