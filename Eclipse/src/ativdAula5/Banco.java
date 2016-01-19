package ativdAula5;

import restaurante.Mesa;

public class Banco {
	
	Conta[] contas;
	private int count = 0;
	
	public Banco(){
		this.contas = new Conta[10];
		for (int i = 0; i < contas.length; i++) {
			contas[i] = new Conta();
		}
	}
	
	public void adicionar(Conta c){
		contas[count++] = c;
	}
	
	public Conta pegarConta(int x){
		return contas[x];
	}
	
	public int pegarTotalDeContas(){
		return this.count;
	}
}
