package aula5;

public class Gerente extends Funcionario {

	private int nivel;

	@Override
	public String toString() {
		this.turno = "Tarde";
		return "Ger. " + super.toString() + "Nivel: " + this.nivel + "\n";
	}

	@Override
	public double getBonus(){
		return this.getSalario() * 0.3;
	}
	
	/*@Override
	public void cracha(){
		System.out.println("BTG - " + this.getNome() + " - Eu sou gerente");
	}*/
	
	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}
		
}
