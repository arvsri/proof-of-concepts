package self.poc.endpoints.serviceactivators;

import org.springframework.integration.Message;

public class MyHelloService {

	public String sayHello(Message<?> msg) {
		return "Hello " + msg.getPayload().toString();
	}
	
}
