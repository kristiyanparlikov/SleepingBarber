package barberShop2;

public class Customer extends Thread {
	 private BarberSalon salon;
	 
	 public Customer(BarberSalon salon) {
	     this.salon = salon;
	 }

	@Override
	public void run() {
	         try {
	        	Thread.sleep(Math.round((Math.random() * 1000)));
	        	salon.enterSalon();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	         super.run();
	}
	
	public void sitInBarberChair() throws InterruptedException {
	 salon.getHaircut(this);	
	}
}