package gildasiozeth.banco.principal;
import gildasiozeth.banco.modelo.*;

public class TestaDeposito {
	public static void main(String[] args) {
		Conta cp = new Conta(null);
		try{
			cp.depositar(-100);
		}catch (InvalidValueException e) {
			System.out.println(e.getMessage());
		}
	}
}
