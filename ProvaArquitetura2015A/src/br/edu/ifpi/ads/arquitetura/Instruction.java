package br.edu.ifpi.ads.arquitetura;

public class Instruction {

	private Short instruction;
	private Short pc;
	private Short result = null;
	
	// nao usado na prova...:)
	private byte target;
	
	private Short operand1 = 0;
	private Short operand2 = 0;
	
	private Short operandPC1 = null;
	private Short operandPC2 = null;
	
	public boolean isIssued = false;
	
	public String toString(){
		return "\nPC: " + this.getPc()
		+ " // Operation: " + this.instruction
		+ " // Target: " + this.target
		+ "\nOperand1: " + this.operand1
		+ " // Operand2: " + this.operand2
		+ " // WaitingPC1: " + this.operandPC1
		+ " // WaitingPC2: " + this.operandPC2
		+ " // ReadyToWrite: " + this.isReadyToWrite()
		+ " // ReadyToIssue: " + this.isReadyToIssue() + "]"
		+ "\nResult: " + this.getResult();
	}
	
	public boolean isReadyToIssue(){
		return (operandPC1 == null && operandPC2 == null);
	}
	
	public boolean isReadyToWrite(){
		return (result != null);
	}

	public Short getInstruction() {
		return instruction;
	}

	public void setInstruction(Short instruction) {
		this.instruction = instruction;
	}

	public Short getPc() {
		return pc;
	}

	public void setPc(Short pc) {
		this.pc = pc;
	}

	public Short getOperand1() {
		return operand1;
	}

	public void setOperand1(Short operand1) {
		this.operand1 = operand1;
	}

	public Short getOperand2() {
		return operand2;
	}

	public void setOperand2(Short operand2) {
		this.operand2 = operand2;
	}

	public Short getResult() {
		return result;
	}

	public void setResult(Short result) {
		this.result = result;
	}

	public Short getOperandPC1() {
		return operandPC1;
	}

	public void setOperandPC1(Short operandPC1) {
		this.operandPC1 = operandPC1;
	}

	public Short getOperandPC2() {
		return operandPC2;
	}

	public void setOperandPC2(Short operandPC2) {
		this.operandPC2 = operandPC2;
	}
}
