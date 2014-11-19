package self.poc.scheduled;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimedLogger {

	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm:sss");

	public void doStuff(){
		System.out.println(" ----------Invoked TimedLogger#doStuff() on " + dateFormat.format(new Date()) + " --------------------------");
	}
	
}
