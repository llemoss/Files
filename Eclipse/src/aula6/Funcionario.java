package aula6;

public /*final*/ class Funcionario {
	
	private int cpf;
	private String nome;
	private double salario;
	private Cargo cargo;
	
	protected String turno;
	
	@Override
	public String toString() {
		return this.nome + " // CPF: " + this.cpf + "\nSalario: " + this.salario + " // Bonus: " + this.getBonus() + "\nCargo: " + cargo.getNome() + "\n";
	}
	
	public final void cracha(){
		System.out.println("BTG - " + this.getNome());
	}
	
	public Funcionario (){}
	
	public double getBonus(){
		return this.cargo.getBonus(this.salario);
	}
	
	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public int getCpf() {
		return cpf;
	}
	public void setCpf(int cpf) {
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
	
	
	
}
