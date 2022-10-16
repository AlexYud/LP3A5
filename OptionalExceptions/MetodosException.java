package OptionalExceptions;

import java.util.InputMismatchException;
import java.util.Optional;
import java.util.Scanner;

class ExceptionClass extends Throwable {
	ExceptionClass(String message) {
		super();
	}
	ExceptionClass(String message, Throwable cause) {
		super(message, cause);
	}
}

public class MetodosException {
	
	public static void captureException() {
		// Ao capturar uma exce��o, gere uma nova exce��o passando a exce��o original como causa.
		try {
			Optional op = Optional.of(null);
			System.out.print(op);
		} catch(Exception e) {
			ExceptionClass excep = new ExceptionClass("Capturou exce��o", e);
			System.out.println(excep);
			// M�todo getCause da nova exce��o criada.
			System.out.println("Causa da exce��o: " + excep.getCause());
		}
	}
	
	public static void multipleExceptions() {
		// Exemplo com tratamento de v�rias exce��es, cada qual em seu bloco catch.
		 Scanner sc = new Scanner(System.in);
		    boolean continua = true;

		    do{
		      try{
		        System.out.print("Numerador: ");
		        int numerador = sc.nextInt();

		        System.out.print("Denominador: ");
		        int denominador = sc.nextInt();

		        int resultador = calculaQuociente(numerador, denominador);
		        System.out.println("Resultado: "+resultador);

		        continua = false;

		      }catch (InputMismatchException erro1) {
		        System.err.println("N�o � permitido inserir letras, informe apenas n�meros inteiros!");
		        sc.nextLine(); 
		      }catch(ArithmeticException erro2){
		        System.err.println("O n�mero do divisor deve ser diferente de 0!");
		      }catch(NullPointerException erro3){
			    System.err.println("O n�mero n�o pode ser nulo!");
			  }
		    }while(continua);
	}
	
	public static void multipleExceptions2() {
		// Exemplo tratando m�ltiplas exce��es em um mesmo bloco catch, usando o operador "|".
		 Scanner sc = new Scanner(System.in);
		    boolean continua = true;

		    do{
		      try{
		        System.out.print("Numerador: ");
		        int numerador = sc.nextInt();

		        System.out.print("Denominador: ");
		        int denominador = sc.nextInt();

		        int resultador = calculaQuociente(numerador, denominador);
		        System.out.println("Resultado: "+resultador);

		        continua = false;

		      }catch (InputMismatchException | ArithmeticException | NullPointerException erro) {
		        System.err.println(erro);
		        continua = false;
		      }
		    }while(continua);
	}
	
	public static int calculaQuociente(int numerador, int denominador) throws ArithmeticException {
	    return numerador / denominador;
	}

	public static void main(String[] args) throws Exception {
		captureException(); 
//		multipleExceptions();
//		multipleExceptions2();
	}

}


