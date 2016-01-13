package restaurante;

public class Mesa{
	
	public final static String DISPONÍVEL = "Disponível";
	public final static String OCUPADA = "Ocupada";
	public final static String RESERVADA = "Reservada";
	public final static String PRINCIPAL = "Principal";
	public final static String SECUNDARIA = "Secundaria";
	public final static int MAX_PEDIDOS = 4;
	
	private int numero;
	private String status;
	private Pedido[] pedidos;
	private int qtdMaxDePedidosAtual = MAX_PEDIDOS;
	private int contadorDePedidos = 0;
	private double conta = 0;
	private boolean comTaxa;
	private double rateio = 1;
	private Mesa mesaJuntada;
	private String tipo;
	
	public double getRateio() {
		return rateio;
	}

	public void juntar(Mesa mesa){
		this.mesaJuntada = mesa;
		mesa.mesaJuntada = this;
		mesa.tipo = Mesa.SECUNDARIA;
		
		if (mesa.getStatus() != Mesa.OCUPADA)
			mesa.setStatus(Mesa.OCUPADA);
	}
	
	public void setRateio(double rateio) {
		this.rateio = rateio;
	}

	public Mesa(int numero){
		this.numero = numero;
		this.status = Mesa.DISPONÍVEL;
		this.pedidos = new Pedido[qtdMaxDePedidosAtual];
		this.comTaxa = true;
		this.tipo = Mesa.PRINCIPAL;
	}
	
	public void adicionarPedido(Pedido pedido){
		if (this.status != Mesa.OCUPADA)
			return;
		
		pedidos[contadorDePedidos++] = pedido;
		this.conta += pedido.getValor();
		if (contadorDePedidos == qtdMaxDePedidosAtual){
			qtdMaxDePedidosAtual += MAX_PEDIDOS;
			Pedido[] temp = this.pedidos;
			this.pedidos = new Pedido[qtdMaxDePedidosAtual];
			for (int i = 0; i < temp.length; i++) {
				this.pedidos[i] = temp[i];
			}
		}
	}
	
	
	public double conta() {
		double valor = 0;
		
		for (Pedido pedido : this.pedidos) {
			if (pedido == null) break;
			valor += pedido.getValor();
		}
		
		if (comTaxa) valor = valor*1.1;
		
		//Fazer o juntar mesas funcionar
		
		return valor;
	}

	public Pedido[] getPedidos() {
		return pedidos;
	}
	
	public void setComTaxa(boolean comTaxa) {
		this.comTaxa = comTaxa;
	}

	public void setPedidos(Pedido[] pedidos) {
		this.pedidos = pedidos;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String toString() {
		String str = "Mesa de numero: " + numero
				+ " // Contador de pedidos: " + contadorDePedidos 
				+ "\nDescricao \t Valor \n---------------------- \n";
		for (Pedido p : pedidos) {
			if (p == null) break;
			str += p.getDescricao() + "\t" + p.getValor() + "\n";
			}
		str += "----------------------\nConta: " + this.conta() + "\n";
		
		if (this.rateio > 1){
			str += "Rateio: " + conta()/rateio + "\n";
		}
		
		return str;
	}
	
	
}