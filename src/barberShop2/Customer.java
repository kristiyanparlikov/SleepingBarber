package barberShop2;

public class Customer implements Runnable {
	 private int id = 0;
	 private BarberSalon salon = null;
	 
	 public Customer(int id, BarberSalon salon) {
	     this.id = id;
	     this.salon = salon;
	 }

	@Override
	public void run() {
		while (true) {
	    	 System.out.println("Customer with id = " + id + " needs a haircut!");
	         try {
				salon.waitingForHairCut(id);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}