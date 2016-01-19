package aula5;

public class TestaEmpresa {

	public static void main(String[] args) {
		
		Funcionario f1 = new Funcionario();
		f1.setCpf(123);
		f1.setNome("Fulano");
		f1.setSalario(3400);
		
		Gerente g1 = new Gerente();
		g1.setCpf(124);
		g1.setNome("Sicrano");
		g1.setSalario(10000);
		g1.setNivel(5);
		
		Diretor d1 = new Diretor();
		d1.setNome("Beltrano");
		d1.setSalario(3500);
		
		CalculaBonus calculaBonus = new CalculaBonus();
		calculaBonus.Calcular(f1);
		calculaBonus.Calcular(g1);
		calculaBonus.Calcular(d1);
		calculaBonus.showTotal();
		
		g1.cracha();
		f1.cracha();
		
		
	}
}
