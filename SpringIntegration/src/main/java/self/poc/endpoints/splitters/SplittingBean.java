package self.poc.endpoints.splitters;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.integration.Message;
import org.springframework.integration.support.MessageBuilder;

public class SplittingBean {

	public Collection<Message<?>> split(Message<?> msg){
		String payLoad = (String)msg.getPayload();
		String[] splits = payLoad.split(" ");
		
		List<Message<?>> messages = new ArrayList<Message<?>>();
		int i = 0;
		for(String split : splits){
			messages.add(MessageBuilder.withPayload(split).setHeader("Message Id", i++).build());
		}
		return messages;
	}
	
}
