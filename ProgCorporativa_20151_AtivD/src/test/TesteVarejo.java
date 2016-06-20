package test;

import java.util.ArrayList;

import java.util.List;

import base.Cliente;
import base.Compra;
import base.FidelidadeOuro;
import base.Item;

public class TesteVarejo {
	public static void main(String[] args) {
		
		Cliente c = new Cliente(new FidelidadeOuro());
		c.setPontos(1000);
		
		List<Item> compras = new ArrayList<>();
		
		for (int i = 0; i < 20; i++) {
			compras.add(new Item("Alguma coisa", 50));
		}
		
		Compra compra = new Compra(compras, c);
		System.out.println(compra.calcularValorTotal());
	}
}
