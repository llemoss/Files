package caelum;
class PessoaFisica {
	private String nome;
	private String cpf;

	public void setPessoaFisica(String nome, String cpf){
		this.nome = nome;
		this.cpf = cpf;
	}

	public void valida(String cpf){
		if(cpf.length() < 11 || cpf.length() > 11){
			System.out.println("CPF invalido");
			this.cpf = null;
		}
	}

	public String toString(){
		return "Nome: " + nome + " // CPF: " + cpf;
		}
}