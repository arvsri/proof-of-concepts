package self.poc.server;
 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Logger;

import javax.websocket.CloseReason;
import javax.websocket.CloseReason.CloseCodes;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.glassfish.tyrus.server.Server;
 
@ServerEndpoint(value = "/echo")
public class EchoServer {
 
    private Logger logger = Logger.getLogger(this.getClass().getName());
 
    @OnOpen
    public void onOpen(Session session) {
        logger.info("Connected ... " + session.getId());
    }
 
    @OnMessage
    public String onMessage(String message, Session session) {
        switch (message) {
        case "quit":
            try {
                session.close(new CloseReason(CloseCodes.NORMAL_CLOSURE, "Client asked to quit"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            break;
        }
        return "Server Response : " + message;
    }
 
    @OnClose
    public void onClose(Session session, CloseReason closeReason) {
        logger.info(String.format("Session %s closed because of %s", session.getId(), closeReason));
    }
    
    
    public static void main(String[] args) {
        Server server = new Server("localhost", 8025, "/websockets", EchoServer.class);
        
        try {
            server.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Please press a key to stop the server.");
            reader.readLine();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            server.stop();
        }
    }
 
}