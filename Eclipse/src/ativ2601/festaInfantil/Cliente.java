package ativ2601.festaInfantil;

public class Cliente {

	public final static String NOVO = "Novo";
	public final static String ANTIGO = "Antigo";
	public final static int MAX_ALUGUEIS = 4;
	
	private String nome;
	private String telefone;
	private String endereco;
	private Aluguel[] alugueis;
	private int qtdMaxAlugueis = MAX_ALUGUEIS;
	private int contadorAlugueis = 0;
	private String tipo;
	
	public String toString() {
		return "Nome: " + this.nome + "\nQuantidade de alugueis: " + this.contadorAlugueis + "\nValor total de alugueis: " + getValorTotal() + "\n";
	}
	
	Cliente(String nome, String telefone, String endereco){
		this.nome = nome;
		this.telefone = telefone;
		this.endereco = endereco;
		this.tipo = NOVO;
		this.alugueis = new Aluguel[MAX_ALUGUEIS];
	}
	
	Cliente(Tema temaEscolhido){
		this.tipo = ANTIGO;
		this.alugueis = new Aluguel[MAX_ALUGUEIS];
	}
	
	public void adicionarAluguel(Aluguel aluguel){
		
		this.alugueis[contadorAlugueis++] = aluguel;
		
		if (contadorAlugueis == qtdMaxAlugueis){
			this.qtdMaxAlugueis += MAX_ALUGUEIS;
			Aluguel[] temp = this.alugueis;
			this.alugueis = new Aluguel[qtdMaxAlugueis];
			for (int i = 0; i < temp.length; i++) {
				this.alugueis[i] = temp[i];
			}
		}
	}
	
	public double getValorTotal(){
		double valorTotal = 0;
		for (Aluguel aluguel : alugueis) {
			if (aluguel != null){valorTotal += aluguel.getValorAluguel();}
		}
		if (this.tipo == ANTIGO){valorTotal *= 0.8;}
		return valorTotal;
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
	
	public String getTipo() {
		return tipo;
	}
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
}
