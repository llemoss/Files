package caelum;
class TestaFuncionario{
	public static void main(String[] args){
		Funcionario f1 = new Funcionario();
		Data dataf1 = new Data();
		dataf1.setData(06, 01, 2016);
		f1.setNome("Gil");
		f1.setSalario(800);
		f1.setData(dataf1);
		f1.setRg("123456789");

		System.out.println(f1);

		f1.recebeAumento(500);

		f1.getGanhoAnual();

		f1.mostrarLog();
		}
}