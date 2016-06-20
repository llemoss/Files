package base;

public class DescontoPorQuantidade implements Promocao {

	@Override
	public double obterDesconto(Compra compra) {
		return (compra.getItensDaCompra().size() >= 20) ? 0.05 : 0;
	}

}
