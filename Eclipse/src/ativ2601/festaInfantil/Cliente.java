package ativ2601.festaInfantil;

public class Cliente {

	public final static String NOVO = "Novo";
	public final static String ANTIGO = "Antigo";
	
	private String nome;
	private String telefone;
	private String endereco;
	private Tema temaEscolhido;
	private String dataFesta;
	private String horaComecoFesta;
	private String horaFinalFesta;
	private String tipo;
	private double valorAluguel;
	
	public String toString() {
		return "Nome: " + this.nome + "\nTema escolhido: " + this.temaEscolhido.getNome() + "\nValor do aluguel: " + this.valorAluguel + "\n";
	}
	
	
	Cliente(String nome, String telefone, String endereco, Tema temaEscolhido, String dataFesta){
		this.nome = nome;
		this.telefone = telefone;
		this.endereco = endereco;
		this.temaEscolhido = temaEscolhido;
		this.valorAluguel = temaEscolhido.getValor();
		this.dataFesta = dataFesta;
		this.tipo = NOVO;
	}
	
	Cliente(Tema temaEscolhido){
		this.tipo = ANTIGO;
		this.temaEscolhido = temaEscolhido;
		this.valorAluguel = temaEscolhido.getValor();
	}

	public double getValorAluguel() {
		return valorAluguel;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getTelefone() {
		return telefone;
	}
	
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public String getEndereco() {
		return endereco;
	}
	
	public void setEndereco(String endereco) {
		this.endereco = endereco;
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
	
	public String getTipo() {
		return tipo;
	}
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
}
