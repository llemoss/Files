package br.edu.ifpi.ads.arquitetura;

import java.util.ArrayList;

// Implementar unidade de atualizacao de registradores, com
// buffer para até 4 instrucoes.

public class RegisterUpdateUnit {
	
	ArrayList<Instruction> queue = new ArrayList<>();
	
	// TODO deve enfileirar instrucao ja decodificada para
	// despacho (issue). Retornar false se unidade estiver cheia.
	public boolean push(Instruction i) {
		queue.add(i);
		return true;
	}
	
	// TODO deve retornar a primeira instrucao que esteja pronta para despacho (contendo
	// todos os dados necessarios), com base na ordem de entrada (mas podendo pular
	// instrucao que nao esteja completa).
	// instrucoes prontas devem possuir operandPCs nulos, indicando que nao possuem
	// dependencias (isso ja vem implementado nos testes)
	public Instruction issue(){
		for (int i = 0; i < queue.size(); i++) {
			Instruction ri = queue.get(i);
			if(ri.isReadyToIssue() && !ri.isIssued){
				ri.isIssued = true;
				queue.set(i, ri);
				return ri;
			}
		}
		return null;
	}
	
	// TODO deve retornar a proxima instrucao que pode ser removida para gravacao nos
	// registradores (contem result nao nulo)
	public Instruction pop() {
		Instruction i = queue.get(0);
		if(i.isReadyToWrite()){
			queue.remove(0);
			return i;
		}
		return null;
	}
	
	// TODO deve percorrer a fila de instrucoes e atualizar resultados e operandos,
	// permitindo novas instrucoes serem removidas (pop), despachadas (issue), e inseridas
	// (por liberar espaco com pop).
	public void setResult(Short pc, Short result) {
		for (int i = 0; i < queue.size(); i++) {
			Instruction ri = queue.get(i);
			
			if(ri.getOperandPC1() == pc){
				ri.setOperandPC1(null);
			}
			
			if(ri.getOperandPC2() == pc){
				ri.setOperandPC2(null);
			}
			
			if(ri.getPc() == pc){
				ri.setResult(result);
			}
			
			queue.set(i, ri);
		}
	}

}
