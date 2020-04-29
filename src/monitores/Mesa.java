package monitores;

public class Mesa {
	int count = 0;
	ListaCircular<String> estados = new ListaCircular<String>();

	public Mesa() {
		for (int i = 0; i < 5; i++) {
			estados.add("Pensando");
		}
	}

	public synchronized void probar_bocado(int i) {
		if (estados.get(i) == "Con Hambre" && estados.get(i - 1) != "Comiendo" && estados.get(i + 1) != "Comiendo") {
			estados.set(i, "Comiendo");
		}
	}

	public synchronized void tomar_tenedores(int i) {
		while (estados.get(i - 1) == "Comiendo" || estados.get(i + 1) == "Comiendo") {
			Util.myWait(this);
		}
		estados.set(i, "Con Hambre");
		probar_bocado(i);
	}

	public synchronized void bajar_tenedores(int i) {
		probar_bocado(i - 1);
		probar_bocado(i + 1);
		estados.set(i, "Pensando");
		notify();
	}
}
