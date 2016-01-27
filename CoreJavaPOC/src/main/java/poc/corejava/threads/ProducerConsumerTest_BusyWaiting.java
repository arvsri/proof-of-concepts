package poc.corejava.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


// Entities - Chef ( producer ), Waiter ( Consumer ), Food, Restaurant ( holds producer and consumer )
// Chef - a thread - keeps producing food for restaurant
// Waiter - another thread - keeps picking the food which chef produces for restaurant and keeps delivering somewhere 
// Restaurant holds the food, chef and waiter --here is how flow goes 
// --  Chef checks if there is no food in restaurant and then produces the food and sets it in Restaurant
// --  Waiter checks if there food in restaurant, waiter picks the food and delivers it 
// -- Both waiter and chef are in loop to continuously check if they need to work or sleep

public class ProducerConsumerTest_BusyWaiting {

    public static void main(String[] args) {
    	ExecutorService executor = Executors.newCachedThreadPool();
    	
    	Restaurant restaurant = new Restaurant();
    	executor.submit(restaurant.getWaiter());
    	executor.submit(restaurant.getChef());
    	
    	try {
			TimeUnit.SECONDS.sleep(20);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    	executor.shutdownNow();
    }

}


class Food{
	private static int incrementor = 0;  
	private final int id = incrementor++;
	
	public String toString(){
		return "Delicious food " + id;
	}
}

class Chef implements Runnable{
	
	private final Restaurant restaurant;
	
	public Chef(Restaurant restaurant){
		this.restaurant = restaurant;
	}
	
	public Food prepare(){
		System.out.println(" Preparing food ");
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			System.out.println("Got interrupted, so throwing exception");
			throw new RuntimeException();
		}
		Food f = new Food();
		System.out.println(" Food is ready : " + f);
		return f;
	}

	@Override
	public void run() {

		// infinite loop to show that chef is working continuously - till interrupted
		while(!Thread.interrupted()){
			if(this.restaurant.getFood() == null){
				// Prepare the food, and set it on restaurant
				Food f = prepare();
				if(this.restaurant.getFood() != null){
					throw new RuntimeException("Error - race condition - I produced food but waitor has not delivered by previous food");
				}
				this.restaurant.setFood(f);
			}else{
				System.out.println("Busy waiting - Food is already present in restaurant");
			}
		}
	}	
}

class Waiter implements Runnable{
	
	private final Restaurant restaurant;
	
	public Waiter(Restaurant restaurant){
		this.restaurant = restaurant;
	}

	public void deliver(Food f){
		System.out.println(" food to be delivered : " + f);
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			System.out.println("Got interrupted, so throwing exception");
			throw new RuntimeException();
		}
		System.out.println(" Food delivered ");
	}
	
	
	@Override
	public void run() {
		
		// infinite loop to show that waiter is working continuously - till interrupted
		while(!Thread.interrupted()){
			if(this.restaurant.getFood() != null){
				// get the food, remove it from restaurant and deliver it
				Food f = this.restaurant.getFood();
				this.restaurant.setFood(null);
				deliver(f);
			}else{
				System.out.println("Busy Waiting - No food is available in restaurant for delivery");
			}
		}
	}
	
}

class Restaurant {
	
	private Food food = null;
	private Chef chef = null;
	private Waiter waiter = null;

	public Restaurant(){
		this.chef = new Chef(this);
		this.waiter = new Waiter(this);
	}
	
	public Food getFood() {
		return food;
	}
	public void setFood(Food food) {
		this.food = food;
	}
	public Chef getChef() {
		return chef;
	}
	public void setChef(Chef chef) {
		this.chef = chef;
	}
	public Waiter getWaiter() {
		return waiter;
	}
	public void setWaiter(Waiter waiter) {
		this.waiter = waiter;
	}
	
}
