package barberShop2;

public class Barber implements Runnable{
	
	private BarberSalon salon = null;

	public Barber(BarberSalon salon) {
		this.salon = salon;
		new Thread(this).start();
	}
	
	@Override
	public void run() {
		while(true) {
			try {
				salon.wantToCut();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
