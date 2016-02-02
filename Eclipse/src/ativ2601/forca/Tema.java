package ativ2601.forca;

public class Tema {
	
	private String nome;
	private String[] ConjuntoPalavras;
	
	Tema(String nome, String conjunto){
		this.nome = nome;
		conjunto = conjunto.toUpperCase();
		this.ConjuntoPalavras = conjunto.split(" ");
	}
	
	Tema(){}
	
	public void setConjuntoPalavras(String conjunto){
		conjunto = conjunto.toUpperCase();
		this.ConjuntoPalavras = conjunto.split(" ");
	}

	public Tema adicionarPalavra(String palavra){
		String str = "";
		for (String p : this.getConjuntoPalavras()) {
			str += p + " ";
		}
		str += palavra;
		this.setConjuntoPalavras(str);
		return this;
	}
	
	public String getNome(){
		return this.nome;
	}
	
	public String[] getConjuntoPalavras(){
		return this.ConjuntoPalavras;
	}
	
	public void mostrarConjunto(){
		String str = "Conjunto de palavras:\n";
		for (String string : ConjuntoPalavras) {
			str += string + "\n";
		}
		System.out.println(str);
	}
	
}
