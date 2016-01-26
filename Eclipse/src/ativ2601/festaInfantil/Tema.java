package ativ2601.festaInfantil;

public class Tema {

	private String nome;
	private double valor;
	private Item listaItens[];
	private int itemCount = 0;
	private String corToalha;
	
	Tema(String nome, String corToalha){
		this.nome = nome;
		this.corToalha = corToalha;
		this.listaItens = new Item[5];
	}
	
	public String getNome() {
		return this.nome;
	}

	public double getValor() {
		this.valor = 0;
		for (Item item : listaItens) {
			if (item != null){this.valor += item.getValor();}
		}
		return this.valor;
	}

	public Item[] getListaItens() {
		return this.listaItens;
	}

	public String getCorToalha() {
		return this.corToalha;
	}

	public void adicionarItem(Item item) {
		listaItens[itemCount++] = item;
	}

	
}
