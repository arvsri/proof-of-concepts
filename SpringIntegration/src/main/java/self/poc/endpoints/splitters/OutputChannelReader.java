package self.poc.endpoints.splitters;

import org.springframework.integration.Message;

public class OutputChannelReader {
	
	public void onMessage(Message<?> msg){
		System.out.println("Received - Message Id = " + msg.getHeaders().get("Message Id") + "  Payload = " + msg.getPayload());
	}

}
