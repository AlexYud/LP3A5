package ProdutorConsumidorExclusao;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Numero {
	private int numero;
	private Semaforo mutex, cheio, vazio;

	Numero(int numero, Semaforo mutex, Semaforo cheio, Semaforo vazio) {
		this.numero = numero;
		this.mutex = mutex;
		this.cheio = cheio;
		this.vazio = vazio;

	}

	public int consumir(String idThread) {

		cheio.P(); // Verifica se está cheio
		mutex.P(); // Garante acesso único
		System.out.println("  Consumidor " + idThread + "\t consumiu: \t" + this.numero);

		mutex.V(); // Libera acesso 
		vazio.V(); // Notifica as threads que está vazio

		return this.numero;

	}

	public void produzir(String idThread, int valor) {

		vazio.P(); // Verifica se está vazio
		mutex.P(); // Garante acesso único

		this.numero = valor;
		System.out.println("Produtor " + idThread + "\t produziu: \t" + valor);

		mutex.V(); // Libera acesso 
		cheio.V(); // Notifica as threads que está cheio
	} 

}
