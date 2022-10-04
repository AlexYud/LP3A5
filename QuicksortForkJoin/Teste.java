/*-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
													
	Implementação do Quicksort com o framework Fork/Join
	Referencia: https://gist.github.com/EliaRohana/25b924048d990c5358313d18daf8f491		
													
-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/

package QuicksortForkJoin;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;

public class Teste {

	public static void main(String[] args) {
		int[] lista = new int[50];
		
	    Random rand = new Random();
	    
	    for (int i = 0; i < lista.length; i++) lista[i] = rand.nextInt(51);

	    System.out.println("Lista desordenada = " + Arrays.toString(lista));
	    
	    QuicksortForkJoin quickSort = new QuicksortForkJoin(lista);
	    ForkJoinPool pool = new ForkJoinPool();
	    pool.invoke(quickSort);
	    pool.shutdown();
	    
	    System.out.println("Lista ordenada = " + Arrays.toString(lista));
	  }

}
