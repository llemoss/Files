package caelum;
class Funcionario{
	private String nome;
	private static int identificador;
	private double salario;
	private Data dataEntrada;
	private String rg;
	private String log = "Registro de transferencias:\n";

	public String toString(){ //Questao 3: coloquei logo o toString no lugar do "mostra" que a apostila sugere
		return "Nome: " + nome + "\n" + "Salario: " + salario + "\n" + "Data de entrada: " + dataEntrada + "\n" + "RG: " + rg;
	}

	public Funcionario() {
		Funcionario.identificador = Funcionario.setIdentificador();
	}

	public static int setIdentificador()
	{
		return ++identificador;
	}

	public int getIdentificador(){
		return identificador;
	}
	
	public Funcionario(String nome) {
		this.nome = nome;
		Funcionario.identificador = Funcionario.setIdentificador();
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

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public void recebeAumento(double valor){
		salario += valor;
		String info = "Salario aumentado em " + valor + " // Novo valor: " + salario;
		log += info;
	}

	public void getGanhoAnual(){
		System.out.println("Ganho anual: " + salario*12.0);
	}

	public Data getData() {
		return dataEntrada;
	}

	public void setData(Data dataEntrada) {
		this.dataEntrada = dataEntrada;
	}

	public void mostrarLog(){
		System.out.println(log);
	}
}