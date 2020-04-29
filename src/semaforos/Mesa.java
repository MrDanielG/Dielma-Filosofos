package semaforos;

public class Mesa {
	int count = 0;
	SemaforoBinario mutex = new SemaforoBinario(true);
	SemaforoContador[] sinc = new SemaforoContador[5];
	ListaCircular<String> estados = new ListaCircular<String>();

	public Mesa() {
		for (int i = 0; i < 5; i++) {
			estados.add("Pensando");
			sinc[i] = new SemaforoContador(0);
		}
	}

	public void probar_bocado(int i) {
		if (estados.get(i) == "Con Hambre" && estados.get(i - 1) != "Comiendo" && estados.get(i + 1) != "Comiendo") {
			estados.set(i, "Comiendo");
			sinc[i].V();
		}
	}

	public void tomar_tenedores(int i) {
		mutex.P();
		estados.set(i, "Con Hambre");
		probar_bocado(i);
		mutex.V();
		sinc[i].P();
	}

	public void bajar_tenedores(int i) {
		mutex.P();
		probar_bocado(i - 1);
		probar_bocado(i + 1);
		mutex.V();
	}
}
