package aula;

public class Cliente {
	private String nome;
	private String cpf;
	private String cidade;
	
	public Cliente(String titular, String cpf, String cidade) {
		this.nome = titular;
		this.cpf = cpf;
		this.cidade = cidade;
	}
	
	public String toString(){
		return this.nome;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
}
