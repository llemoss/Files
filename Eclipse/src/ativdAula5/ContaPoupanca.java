package ativdAula5;

public class ContaPoupanca extends Conta{
	
	@Override
	public void atualizar(double taxa){
		super.atualizar(taxa*3);
	}

}
