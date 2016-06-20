package base;

public class FidelidadeOuro implements TipoDeFidelidade {

	@Override
	public double resgatarPontosEmDesconto(int pontos) {
		return (pontos >= 1000) ? 0.05 : 0;
	}

}
