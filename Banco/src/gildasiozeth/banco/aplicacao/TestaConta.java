package gildasiozeth.banco.aplicacao;
import gildasiozeth.banco.modelo.*;

public class TestaConta {

	public static void main(String[] args) {

		Conta conta = new Conta(new Cliente("Rogerio", "123"));
		
		conta.depositar(100);
		try{
			conta.sacar(1000);
		}catch(InsufficientBalanceException e){
			System.out.println(e.getMessage());
		}catch(DailyLimitException e){
			System.out.println(e.getMessage() + "\nTente sacar um valor menor que 1000");
		}catch(Exception e){
			System.out.println("Ocorreu algum erro na transação");
		}
		
		System.out.println(conta);
	}

}
