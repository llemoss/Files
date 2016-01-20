package aula6;

public class TestaEmpresa {

	public static void main(String[] args) {
		
		Cargo caixa = new CargoCaixa();
		Cargo gerente = new CargoGerente();
		Cargo zelador = new CargoZelador();
		
		Funcionario f1 = new Funcionario();
		f1.setCpf(123);
		f1.setNome("Fulano");
		f1.setSalario(3400);
		f1.setCargo(caixa); //10%
		
		f1.setCargo(gerente); //30%
		
		f1.setCargo(zelador); //5%
		
		CalculaBonus calculaBonus = new CalculaBonus();
		calculaBonus.Calcular(f1);
		calculaBonus.showTotal();
		
		//g1.cracha();
		System.out.println(f1);
		
		
	}
}
