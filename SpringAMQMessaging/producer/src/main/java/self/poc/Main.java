package self.poc;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		
		// Start the AMQ first 
		// $AMQ_HOME/bin/activemq start
		
		ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
		MessageSender messageSender = context.getBean("messageSender", MessageSender.class);
		
		Map<String,String> map = new HashMap<String,String>();
		map.put("Name", "Arvind Srivastava");
		messageSender.send(map);	
		
		System.out.println(" Message send successfully ");

	}

}
