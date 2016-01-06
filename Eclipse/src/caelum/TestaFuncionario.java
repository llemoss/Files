package caelum;
class TestaFuncionario{
	public static void main(String[] args){
		Funcionario f1 = new Funcionario();
		Data dataf1 = new Data();
		dataf1.dia = 06;
		dataf1.mes = 01;
		dataf1.ano = 2016;
		f1.setNome("Gil");
		f1.setSalario(800);
		f1.setData(dataf1);
		f1.setRg("123456789");

		/*Funcionario f2 = new Funcionario();
		Data dataf2 = new Data();
		f2.nome = "Gil";
		f2.salario = 800;
		f2.dataEntrada = dataf2;
		f2.rg = "123456789";*/

		System.out.println(f1);

		f1.recebeAumento(500);

		f1.getGanhoAnual();

		f1.mostrarLog();
		}
}