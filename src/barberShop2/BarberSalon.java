package barberShop2;

import java.util.concurrent.ArrayBlockingQueue;

public class BarberSalon {
	
	
	private ArrayBlockingQueue<Customer> waitingSeats;
	private int haircutTime;
	
	public BarberSalon(int waitingSeats, int haircutTime) {
		this.waitingSeats = new ArrayBlockingQueue<Customer>(waitingSeats);
		this.haircutTime = haircutTime;
	}
	
	public void enterSalon() {
		Customer customer = (Customer) Thread.currentThread();
		System.out.println(customer.getName() + " arrived");
		if(waitingSeats.remainingCapacity() > 0) {
			waitingSeats.offer(customer);
		}else {
			System.out.println("No more free seats in the waiting room, " + customer.getName() + " left!");
		}
		synchronized(this) {
			notifyAll();
		}
	}
	
	synchronized public void work() throws InterruptedException {
		System.out.println("Barber starts his shift.");
		
		while(true) {
			while(waitingSeats.size() == 0) {
				System.out.println("Barber is sleeping in his chair...");
				wait();
			}
			serveCustomers();
		}
	}
	
	public void serveCustomers() throws InterruptedException {
		System.out.println(waitingSeats.peek().getName() + " wakes up the barber.");
		
		while(!waitingSeats.isEmpty()) {
			waitingSeats.poll().sitInBarberChair();
		}
	}
	
	synchronized public void getHaircut(Customer customer) throws InterruptedException {
		String name = customer.getName();
		
		System.out.println("The barber is cutting " + name + "'s hair...");
		cutHair();
		System.out.println(name + "'s hair is done.");
	}
	
	public void cutHair() throws InterruptedException {
		Thread.sleep(haircutTime * 1000);
	}
	
}