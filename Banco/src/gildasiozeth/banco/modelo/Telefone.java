package gildasiozeth.banco.modelo;

public class Telefone {
	
	private String tipo;
	private String telefone;
	
	public Telefone() {
		// TODO Auto-generated constructor stub
	}
	
	public Telefone(String tipo, String telefone) {
		this.tipo = tipo;
		this.telefone = telefone;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	

}
