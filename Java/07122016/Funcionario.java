//Questao 1 e 2:
class Funcionario{
	String nome;
	double salario;
	Data dataEntrada;
	String rg;
	String log = "Registro de transferencias:\n";

	public String toString(){ //Questao 3: coloquei logo o toString no lugar do "mostra" que a apostila sugere
		return "Nome: " + nome + "\n" + "Salario: " + salario + "\n" + "Data de entrada: " + dataEntrada + "\n" + "RG: " + rg;
	}

	public void recebeAumento(double valor){
		salario += valor;
		String info = "Salario aumentado em " + valor + " // Novo valor: " + salario;
		log += info;
	}

	public void calculaGanhoAnual(){
		System.out.println("Ganho anual: " + salario*12.0);
	}

	public void mostrarLog(){
		System.out.println(log);
	}
}