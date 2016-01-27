package ativ2601.festaInfantil;

public class TestaFesta {

	public static void main(String[] args) {
		
		Tema Cinderela = new Tema("Cinderela", "Azul clara");
	    Item Castelo = new Item("Castelo", 250);
	    Cinderela.adicionarItem(Castelo);
	    
	    Aluguel aluguel1 = new Aluguel(Cinderela, "26/01/2016", "18h", "22h");
		
		Cliente cliente1 = new Cliente("Julia", "123456789", "Rua Aquela La, numero 1234");
		cliente1.adicionarAluguel(aluguel1);
		Cliente cliente2 = new Cliente(Cinderela);
		cliente2.adicionarAluguel(aluguel1);
		cliente2.adicionarAluguel(aluguel1);
		cliente2.setNome("Fulano");
		
		System.out.println(cliente1);
		System.out.println(cliente2);
		
	}
}
