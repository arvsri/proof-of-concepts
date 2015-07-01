package self.poc.endpoints.serviceactivators;

import org.springframework.integration.Message;

public class MessageReceiver {

	public void receive(Message<?> msg){
		System.out.println("Received - " + msg.getPayload() );
	}
	
}
