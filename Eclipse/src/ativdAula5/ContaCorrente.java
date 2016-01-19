package ativdAula5;

public class ContaCorrente extends Conta{
	
	@Override
	public void atualizar(double taxa){
		super.atualizar(taxa*2);
	}

}
