package barberShop2;

public class Barber extends Thread{
	
	private BarberSalon salon;

	public Barber(BarberSalon salon) {
		this.salon = salon;
	}
	
	@Override
	public void run() {
			try {
				salon.work();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			super.run();
	}
}
