class TestaFuncionario{
	public static void main(String[] args){
		Funcionario f1 = new Funcionario();
		Data dataf1 = new Data();
		dataf1.dia = 06;
		dataf1.mes = 01;
		dataf1.ano = 2016;
		f1.nome = "Gil";
		f1.salario = 800;
		f1.dataEntrada = dataf1;
		f1.rg = "123456789";

		/*Funcionario f2 = new Funcionario();
		Data dataf2 = new Data();
		f2.nome = "Gil";
		f2.salario = 800;
		f2.dataEntrada = dataf2;
		f2.rg = "123456789";*/

		Funcionario f2 = f1;

		System.out.println(f1);

		f1.recebeAumento(500);

		f1.calculaGanhoAnual();

		f1.mostrarLog();

		if (f1 == f2) {System.out.println("Iguais");}
		else{ System.out.println("Diferentes");}
		//Questao 4: O if retorna "Diferentes" porque sao objetos diferentes, apesar de terem os mesmos conteudos
		//Questao 5: O if retorna "Iguais" porque o segundo objeto foi criado (o que e diferente de dar atributos) usando os dados do primeiro

		//Funcionario.salario = 1234;
		//Questao 8: Nao faz sentido usar a propria classe porque a propria classe so contem metodos e atributos, nao tem informacoes a serem usadas
	}
}