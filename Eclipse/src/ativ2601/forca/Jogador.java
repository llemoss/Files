package ativ2601.forca;

public class Jogador {
	
	private int pontos;
	private String nome;

	Jogador(String nome){
		this.nome = nome;
	}
	
	public int getPontos() {
		return pontos;
	}
	public void setPontos(int pontos) {
		this.pontos = pontos;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

}
