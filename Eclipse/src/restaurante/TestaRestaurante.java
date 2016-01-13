package restaurante;

public class TestaRestaurante {
	public static void main(String[] args) {
		Restaurante restaurante = new Restaurante("Cajuína", 10);
		
		restaurante.abrirMesa(10);
		Mesa a = restaurante.getMesas()[9];
		a.setRateio(2);
		Pedido p1 = new Pedido("Água s/ gas", 2);
		a.adicionarPedido(p1);
		p1 = new Pedido("Suco", 7);
		a.adicionarPedido(p1);
		p1 = new Pedido("Suco", 7);
		a.adicionarPedido(p1);
		p1 = new Pedido("Suco", 7);
		a.adicionarPedido(p1);
		p1 = new Pedido("Suco", 7.5);
		a.adicionarPedido(p1);
		
		restaurante.abrirMesa(9);
		Mesa b = restaurante.getMesas()[8];
		Pedido p2 = new Pedido("Água c/ gas", 3);
		b.adicionarPedido(p2);
		p2 = new Pedido("Suco", 7);
		b.adicionarPedido(p2);
		
		a.juntar(b);
		
		
		
		
		System.out.println(restaurante);
		
		for (Mesa mesa : restaurante.getMesas()) {
			if(mesa.getStatus() == Mesa.OCUPADA){System.out.println(mesa);}
		}
	}
}
