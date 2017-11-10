package self.poc.client;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.client.WebSocketClient;
import org.springframework.web.socket.client.WebSocketConnectionManager;

public class RetryableWebSocketConnectionManager extends WebSocketConnectionManager {

	private static final ScheduledExecutorService RETRY_EXECUTOR = Executors.newSingleThreadScheduledExecutor();
	
	private long initialDelayInSeconds = 60;
	
	private long delayInSeconds = 120;
	
	public RetryableWebSocketConnectionManager(WebSocketClient client,WebSocketHandler webSocketHandler, String uriTemplate,Object[] uriVariables) {
		super(client, webSocketHandler, uriTemplate, uriVariables);
	}


	public void startWithRetry(){
		RETRY_EXECUTOR.scheduleWithFixedDelay(new RetryTask(), initialDelayInSeconds, delayInSeconds, TimeUnit.SECONDS);
	}
	
	
	private class RetryTask implements Runnable{
		@Override
		public void run() {
			
			boolean running = RetryableWebSocketConnectionManager.super.isRunning();
			boolean connected = RetryableWebSocketConnectionManager.super.isConnected();
			
			if(!running ){
				// start the connection manager if its not already running
				RetryableWebSocketConnectionManager.super.start();
			}else if(running && !connected){
				// If the connection manager is running but websocket has not connected, stop and start the connection manager again
				RetryableWebSocketConnectionManager.super.stop();
				RetryableWebSocketConnectionManager.super.start();
			}
		}
	}


	public void setInitialDelayInSeconds(long initialDelayInSeconds) {
		this.initialDelayInSeconds = initialDelayInSeconds;
	}


	public void setDelayInSeconds(long delayInSeconds) {
		this.delayInSeconds = delayInSeconds;
	}
	
}
