package aula6;

public class CargoGerente implements Cargo {

	private String nome = "Gerente";
	
	@Override
	public double getBonus(double salario) {
		return salario*0.3;
	}


	@Override
	public String getNome() {
		return this.nome;
	}

}
