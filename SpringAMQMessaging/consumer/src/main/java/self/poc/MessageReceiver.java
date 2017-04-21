package self.poc;

import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.MessageListener;

public class MessageReceiver implements MessageListener {

    public void onMessage(final Message message) {
    	
        if (message instanceof MapMessage) {
            final MapMessage mapMessage = (MapMessage) message;
            System.out.println(mapMessage);
			try {
				System.out.println(mapMessage.getString("Name"));
			} catch (JMSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(" Message received successfully ");
        }
    }

}