package barberShop2;

public class BarberShop {

	public static void main(String[] args) throws InterruptedException {
		 String[] customerNames = {
	                "Alanis", "Kristiyan", "Marek", "Damian", "Emilie", "Henrik", "Josh", "Claus", "Lars", "Zac", "Johnny"
	        };

	        BarberSalon barberSalon = new BarberSalon(3, 5);

	        Barber barber = new Barber(barberSalon);
	        barber.setName("Barber");
	        barber.start();

	   
	        for (int i = 0; i < customerNames.length; i++) {
	            long sleepTime = Math.round(Math.random() * 10000);
	            try {
	                Thread.sleep(sleepTime);
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }
	            Customer customer = new Customer(barberSalon);
	            int randomNameIndex = (int) Math.round(Math.random() * 10);
	            customer.setName(customerNames[randomNameIndex]);
	            customer.start();
	        }
	}
	
}
