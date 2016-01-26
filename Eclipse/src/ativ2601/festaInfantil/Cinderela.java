package ativ2601.festaInfantil;

public class Cinderela implements Tema {
	
	private String nome = "Cinderela";
	private double valor;
	private Item listaItens[];
	private int itemCount = 0;
	private String corToalha = "Azul clara";
	
	Cinderela(){
		this.listaItens = new Item[5];
	}
	
	@Override
	public String getNome() {
		return this.nome;
	}

	@Override
	public double getValor() {
		this.valor = 0;
		for (Item item : listaItens) {
			if (item != null){this.valor += item.getValor();}
		}
		return this.valor;
	}

	@Override
	public Item[] getListaItens() {
		return this.listaItens;
	}

	@Override
	public String getCorToalha() {
		return this.corToalha;
	}

	@Override
	public void adicionarItem(Item item) {
		listaItens[itemCount++] = item;
	}

}
