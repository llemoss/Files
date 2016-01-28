public class Tema {
	
	private String nome;
	private String[] ConjuntoPalavras;
	
	Tema(String nome, String conjunto){
		this.nome = nome;
		conjunto = conjunto.toUpperCase();
		this.ConjuntoPalavras = conjunto.split(" ");
	}
	
	Tema(){}

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
