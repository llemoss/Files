package ativ9e10.ativ9;

public class ContaPoupanca extends Conta{

	@Override
	public void atualizar(double taxa) {
		this.setSaldo(this.getSaldo() + (this.getSaldo() * taxa * 3));
	}
	
	/*@Override
	public void atualizar(double taxa){
		super.atualizar(taxa*3);
	}*/

}
