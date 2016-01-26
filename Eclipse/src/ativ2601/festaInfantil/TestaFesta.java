package ativ2601.festaInfantil;

public class TestaFesta {

	public static void main(String[] args) {
		
		Tema Cinderela = new Cinderela();
		Item Castelo = new Castelo();
		Cinderela.adicionarItem(Castelo);
		
		Cliente cliente1 = new Cliente("Julia", "123456789", "Rua Aquela La, numero 1234", Cinderela, "26/01/2016");
		Cliente cliente2 = new Cliente(Cinderela);
		cliente2.setNome("Fulano");
		
		System.out.println(cliente1);
		System.out.println(cliente2);
		
	}
}
