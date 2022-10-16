package OptionalExceptions;

import java.util.Optional;

public class MetodosOptional {
	
	public static void ofMethod(Object valor) {
		try { 
			Optional<Object> op = Optional.of(valor); 
			// Se optional for null ele dispara um NullPointerException
            System.out.println("Optional: " + op); 
        } 
        catch (Exception e) { 
            System.out.println(e); 
        } 
	}
	
	public static void ofNullableMethod(Object valor) {
		try { 
			Optional<Object> op = Optional.ofNullable(valor); 
			// Se optional for null ele não dispara uma Exception, mas retorna empty
            System.out.println("Optional: " + op); 
        } 
        catch (Exception e) { 
            System.out.println(e); 
        } 
	}
	
	public static void filterMethod(Object valor) {
		try { 
			Optional<Object> op = Optional.of(valor); 
            System.out.println("Optional: " + op.filter(o -> o == "test"));
        } 
        catch (Exception e) { 
            System.out.println(e); 
        } 
	}
	
	public static void orElseMethod(Object valor) {
		try { 
			Optional<Object> op = Optional.ofNullable(valor); 
			System.out.println(op.orElse("O valor é null"));
        } 
        catch (Exception e) { 
            System.out.println(e); 
        } 
	}
	
	public static void orElseGetMethod(Object valor) {
		try { 
			Optional<Object> op = Optional.ofNullable(valor); 
			System.out.println(op.orElseGet(() -> {
				// Faz outras coisas complexas aqui
				String resultadoDasCoisasComplexasAcima = "O valor é null";
			    return resultadoDasCoisasComplexasAcima;
			}));
        } 
        catch (Exception e) { 
            System.out.println(e); 
        } 
	}
	
	public static void orElseThrowMethod(Object valor) {
		try { 
			Optional<Object> op = Optional.ofNullable(valor); 
			// Se for null dispara Exception
			System.out.println(op.orElseThrow(IllegalArgumentException::new));
        } 
        catch (Exception e) { 
            System.out.println(e); 
        } 
	}

	public static void main(String[] args) {
        Object valor = null;
        
		ofMethod(valor);
//		ofNullableMethod(valor);
//      filterMethod(valor);
//      orElseMethod(valor);
//      orElseGetMethod(valor);
//      orElseThrowMethod(valor);
	}

}
