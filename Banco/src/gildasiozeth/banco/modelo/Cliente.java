package gildasiozeth.banco.modelo;

public class Cliente {
	
	private String nome;
	private String cpf;
	private String cidade;
	private Telefone[] telefones;
	//private int[] telefonesAntigos = {1,2,3};
	
	public Cliente(String titular, String cpf) {
		this.nome = titular;
		this.cpf = cpf;
		this.telefones = new Telefone[5];
		
		for (int i = 0; i < telefones.length; i++) {
			telefones[i] = new Telefone();
		}
	}
	
	@Override
	public String toString() {
		return " Cliente: "+this.nome;
	}
	
	
	public String getNome() {
		return nome;
	}
	public void setTitular(String titular) {
		this.nome = titular;
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

	public Telefone[] getTelefones() {
		return telefones;
	}

	public void setTelefones(Telefone[] telefones) {
		this.telefones = telefones;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}


}
