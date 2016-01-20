package ativdAula5;

public class ContaCorrente extends Conta{
	
	@Override
	public void atualizar(double taxa){
		super.atualizar(taxa*2);
	}
	
	@Override
	public void depositar(double valor){
		super.depositar(valor - 0.10);
	}

}
