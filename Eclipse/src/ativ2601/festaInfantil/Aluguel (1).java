package ativ2601.festaInfantil;

public class Aluguel {

	private Tema temaEscolhido;
	private String dataFesta;
	private String horaComecoFesta;
	private String horaFinalFesta;
	private double valorAluguel;
	
	Aluguel(Tema temaEscolhido, String dataFesta, String horaComecoFesta, String horaFinalFesta){
		this.temaEscolhido = temaEscolhido;
		this.dataFesta = dataFesta;
		this.horaComecoFesta = horaComecoFesta;
		this.horaFinalFesta = horaFinalFesta;
		this.valorAluguel = temaEscolhido.getValor();
	}
	
	public double getValorAluguel() {
		return valorAluguel;
	}

	public void setValorAluguel(double valorAluguel) {
		this.valorAluguel = valorAluguel;
	}

	public Tema getTemaEscolhido() {
		return temaEscolhido;
	}
	
	public void setTemaEscolhido(Tema temaEscolhido) {
		this.temaEscolhido = temaEscolhido;
	}
	
	public String getDataFesta() {
		return dataFesta;
	}
	
	public void setDataFesta(String dataFesta) {
		this.dataFesta = dataFesta;
	}
	
	public String getHoraComecoFesta() {
		return horaComecoFesta;
	}
	
	public void setHoraComecoFesta(String horaComecoFesta) {
		this.horaComecoFesta = horaComecoFesta;
	}
	
	public String getHoraFinalFesta() {
		return horaFinalFesta;
	}
	
	public void setHoraFinalFesta(String horaFinalFesta) {
		this.horaFinalFesta = horaFinalFesta;
	}

	
}
