package restaurante;

public class Restaurante{
	private String nome;
	private Mesa[] mesas;
	
	
	public Restaurante(String nome, int qtdDeMesas){
		this.nome = nome;
		this.mesas = new Mesa[qtdDeMesas];
		for (int i = 0; i < mesas.length; i++) {
			mesas[i] = new Mesa(i+1);
		}
	}


	public String toString() {
		return "Restaurante: " + nome + "\n" +this.verSituacao() + "\n";
	}

	public Mesa abrirMesa(int numero){
		Mesa m = this.mesas[numero-1];
		m.setStatus(Mesa.OCUPADA);
		return m;
	}
	
	public Mesa[] getMesas() {
		return mesas;
	}
	
	public String verSituacao(){
		int contDisponivel = 0;
		int contOcupada = 0;
		int contReservada = 0;
		double valorTotalAtual = 0;
		
		for (Mesa mesa : mesas){
			if (mesa.getStatus() == Mesa.DISPONÍVEL)
				contDisponivel++;
			if (mesa.getStatus() == Mesa.OCUPADA)
				contOcupada++;
			if (mesa.getStatus() == Mesa.RESERVADA)
				contReservada++;
			if (mesa.getTipo() == Mesa.PRINCIPAL){
				valorTotalAtual += mesa.conta();
			}
		}
		
		
		
		return "Mesas ocupadas: " + contOcupada
				+ ", Mesas disponiveis: " + contDisponivel
				+ ", Mesas reservadas: " + contReservada
				+ "\nValor total atual: " + valorTotalAtual;
	}


	public void setMesas(Mesa[] mesas) {
		this.mesas = mesas;
	}
}