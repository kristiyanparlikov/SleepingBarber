package barberShop2;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class BarberSalon {
	
	// !!! 'P' acquire
	// !!! 'V' release
	
	private Random rand;
	private int numOfChairs;
	private int waitingCustomers = 0;
	private Semaphore customers;
	private Semaphore barber;
	private Semaphore availableSeatAccess; 
	private Semaphore cutting;
	
	public BarberSalon(int numOfChairs) {
		this.numOfChairs = numOfChairs;
		customers = new Semaphore(0);
		barber = new Semaphore(0);
		availableSeatAccess = new Semaphore(1);
		cutting = new Semaphore(0);
	}
	
	//barber's activation method
	public void wantToCut() throws InterruptedException {
		System.out.println("Barber is sleeping, waiting for a customer!");
		customers.acquire();
		availableSeatAccess.acquire();
		waitingCustomers--;
		barber.release();
		System.out.println("Barber has customer/s, waiting = " + waitingCustomers);
		availableSeatAccess.release();
		System.out.println("Barber cutting hair...");
		cutting.acquire();
	}
	
	//customer's activation method
	public void waitingForHairCut(int customerNum) throws InterruptedException { 
		int cutTime;
		availableSeatAccess.acquire();
		if (waitingCustomers < numOfChairs) {
			waitingCustomers++;
			System.out.println("Customer " + customerNum
					+ " in room, waiting=" + waitingCustomers);
		customers.release();;
		availableSeatAccess.release();
		barber.acquire();
		cutTime = randomHairCutTimeInMin(10, 30);
		System.out.println("Customer " + customerNum
				+ " getting haircut for " + cutTime+ " min");
		System.out.println("Customer " + customerNum
				+ " finished haircut");
			cutting.release();
		}else {
			System.out.println("Customer " + customerNum
					+ " room full, waiting=" + waitingCustomers);
			availableSeatAccess.release();;
		}
	}
     public int randomHairCutTimeInMin(int min, int max) {
    	 int randomNum = rand.nextInt((max - min) + 1) + min;
    	 return randomNum;
     }
}
