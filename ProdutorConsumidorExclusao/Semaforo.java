package ProdutorConsumidorExclusao;

public class Semaforo {
	private int contador = 0;

	public Semaforo(int valorInicial) {
		contador = valorInicial;
	}

	public synchronized void P() {
		if (contador <= 0)
			try {
				wait();  // Esperar até que count > 0 
			} catch (InterruptedException e) {
			}
		contador--;
	}

	public synchronized void V() {
		contador++;
		notify(); // Acordar quem estiver em espera 
	}
}
