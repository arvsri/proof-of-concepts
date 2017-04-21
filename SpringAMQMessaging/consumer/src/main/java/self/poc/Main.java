package self.poc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	
	public static void main(String[] args) {
		
		// Start the AMQ first 
		// $AMQ_HOME/bin/activemq start
		
		ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
		context.getBean("messageReceiver", MessageReceiver.class);

	}

}
