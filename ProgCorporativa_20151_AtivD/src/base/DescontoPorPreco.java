package base;

public class DescontoPorPreco implements Promocao {

	@Override
	public double obterDesconto(Compra compra) {
		return (compra.calcularValorDaCompra() >= 1000) ? 0.10 : 0;
	}

}
