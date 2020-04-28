package barberShop2;

public class BarberShop {

	public static void main(String[] args) throws InterruptedException {
		BarberSalon salon = new BarberSalon(3);
		Barber barber = new Barber(salon);
		
		for(int i = 0; i < 10; i++) {
			new Customer(i, salon);
		}
			System.out.println("All customer threads started");
			System.out.println("Time to stop the customer threads and exit");
		
			System.exit(0); 
	}
	
}
