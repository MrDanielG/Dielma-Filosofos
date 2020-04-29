package monitores;

public class Filosofo implements Runnable {
	Mesa b = null;
	int i;

	public Filosofo(Mesa _b, int _i) {
		this.i = _i;
		this.b = _b;
		new Thread(this).start();
	}

	public void run() {
		while (true) {
			System.out.println("Filosofo " + i + " PENSANDO en cura del COVID-19");
			System.out.println("Filosofo " + i + " se lava las manos por que quiere comer");

			b.tomar_tenedores(i);
			Util.mySleep(2000);

			System.out.println("Filosofo " + i + " COMIENDO con tenedor " + i + " tenedor " + ((i + 1) % 5));

			Util.mySleep(2000);
			b.bajar_tenedores(i);

			System.out.println("Filosofo " + i + " BAJANDO tenedor " + i + " tenedor " + ((i + 1) % 5));
		}
	}
}
