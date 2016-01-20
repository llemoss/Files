package aula6;

public interface Cargo {
	
	public default double getBonus(double salario){
		return salario*0.05;
	};
	public String getNome();
	
}
