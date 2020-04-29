package semaforos;

//Al utilizar semaforos se generan deadlocks, haciendo que solo un par de filosofos puedan seguir comiendo
public class Practica10 {
	public static void main(String[] args) {
		Mesa buffer = new Mesa();
		Filosofo filosofos[] = new Filosofo[5];

		for (int i = 0; i < 5; i++) {
			filosofos[i] = new Filosofo(buffer, i);
		}
	}
}
