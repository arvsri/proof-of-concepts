package poc.corejava.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

// Liveness Hazard happens when the threads are active and there is no deadlock but still the program is not progressing
// Can happen due to hoisting - a kind of JVM optimization -- in lack of synchronization complier replaces code like 
// while(!stop){ doSomething() }  -- to -- if(!stop){ while(true){ doSomething() }}   
// to fix this .. done variable should be marked as volatile
public class LivenessHazard {

	public static void main(String[] args) {
		ExecutorService executor = Executors.newCachedThreadPool();
		MyWork work = new MyWork();
		executor.submit(work);
		executor.shutdown();
		
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// stop the work now 
		work.done = true;
	}

}


class MyWork implements Runnable{

	boolean done = false;
	
	@Override
	public void run() {
		int i = 0;
		while(!done){
			i++;
			doSomething(i);
		}
	}

	private void doSomething(int i) {
		System.out.println("I am doing some random work " + i);
	}
	
}

