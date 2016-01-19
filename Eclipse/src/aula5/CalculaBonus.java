package aula5;

public class CalculaBonus{
	
	private double total;
	
	public void Calcular(Funcionario f){
		this.total += f.getBonus();
		if (f instanceof Gerente){
			this.total += 1000;	
		}
	}
	
	public void showTotal(){
		System.out.println("Bonus total: " + this.total + "\n");
	}
	
}
