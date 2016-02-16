package gildasiozeth.banco.modelo;

public class InvalidValueException extends Exception {
	
	public InvalidValueException(double valor){
		super("Valor invalido: " + valor);
	}
	
}
