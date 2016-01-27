package poc.corejava.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

//Entities - MyChef ( producer ), MyWaiter ( Consumer ), MyFood, MyRestaurant ( holds producer and consumer )
//MyChef - a thread - keeps producing food for restaurant
//MyWaiter - another thread - keeps picking the food which chef produces for restaurant and keeps delivering somewhere 
//MyRestaurant holds the food, chef and waiter --here is how flow goes 
//--  MyChef checks if there is no food in restaurant and then produces the food and sets it in MyRestaurant
//--  MyWaiter checks if there food in restaurant, waiter picks the food and delivers it 
//--  MyWaiter notifies to the MyChef when it delivers the food. MyChef notifies to the waiter when it picks
// TODO - to be implemented
public class ProducerConsumerTest_WaitNotify {

    public static void main(String[] args) {
    	ExecutorService executor = Executors.newCachedThreadPool();
    	
    	MyRestaurant restaurant = new MyRestaurant();
    	MyChef chef = new MyChef(restaurant);
    	MyWaiter waiter = new MyWaiter(restaurant);
    	
    	executor.submit(waiter);
    	executor.submit(chef);
    	
    	try {
			TimeUnit.SECONDS.sleep(20);
		} catch (InterruptedException e) {}
    	
    	executor.shutdownNow();
    }

}

class MyFood{
	private static int incrementor = 0;  
	private final int id = incrementor++;
	
	public String toString(){
		return "Delicious food " + id;
	}
}

class MyChef implements Runnable{
	
	private final MyRestaurant restaurant;
	
	public MyChef(MyRestaurant restaurant){
		this.restaurant = restaurant;
	}
	
	public MyFood prepare(){
		System.out.println(" Preparing food ");
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			System.out.println("Got interrupted, so throwing exception");
			throw new RuntimeException();
		}
		MyFood f = new MyFood();
		System.out.println(" MyFood is ready : " + f);
		return f;
	}

	@Override
	public void run() {

		// infinite loop to show that chef is working continuously - till interrupted
		while(!Thread.interrupted()){

			synchronized (this.restaurant) {
				while(this.restaurant.getFood() != null){
					try {
						wait();
					} catch (InterruptedException e) {
						break;
					}
				}
			}
			
			
			if(this.restaurant.getFood() == null){
				// Prepare the food, and set it on restaurant
				MyFood f = prepare();
				if(this.restaurant.getFood() != null){
					throw new RuntimeException("Error - race condition - I produced food but waitor has not delivered by previous food");
				}
				this.restaurant.setFood(f);
			}
		}
	}	
}

class MyWaiter implements Runnable{
	
	private final MyRestaurant restaurant;
	
	public MyWaiter(MyRestaurant restaurant){
		this.restaurant = restaurant;
	}

	public void deliver(MyFood f){
		System.out.println(" food to be delivered : " + f);
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			System.out.println("Got interrupted, so throwing exception");
			throw new RuntimeException();
		}
		System.out.println(" MyFood delivered ");
	}
	
	
	@Override
	public void run() {
		
		// infinite loop to show that waiter is working continuously - till interrupted
		while(!Thread.interrupted()){
			if(this.restaurant.getFood() != null){
				// get the food, remove it from restaurant and deliver it
				MyFood f = this.restaurant.getFood();
				this.restaurant.setFood(null);
				deliver(f);
			}else{
				System.out.println("No food is available in restaurant for delivery - so sleeping");
				try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
					System.out.println("Got interrupted, so returning");
					return;
				}
			}
		}
	}
	
}

class MyRestaurant {
	
	private MyFood food = null;
	private MyChef chef = null;
	private MyWaiter waiter = null;

	
	
	public MyFood getFood() {
		return food;
	}
	public void setFood(MyFood food) {
		this.food = food;
	}
	public MyChef getChef() {
		return chef;
	}
	public void setChef(MyChef chef) {
		this.chef = chef;
	}
	public MyWaiter getWaiter() {
		return waiter;
	}
	public void setWaiter(MyWaiter waiter) {
		this.waiter = waiter;
	}
	
}




