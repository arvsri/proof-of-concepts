package self.poc.client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.logging.Logger;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.AbstractWebSocketHandler;

public class SimpleWebSocketHandler extends AbstractWebSocketHandler{
	
    private Logger logger = Logger.getLogger(this.getClass().getName());
	
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		logger.info("Connected ... " + session.getId());
		session.sendMessage(new TextMessage("start"));
    }

	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
		logger.info("Received ...." + message.getPayload());
		String userInput = bufferRead.readLine();
		session.sendMessage(new TextMessage(userInput));
	}

	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        logger.info(String.format("Session %s close because of %s", session.getId(), status));
	}
	
}
