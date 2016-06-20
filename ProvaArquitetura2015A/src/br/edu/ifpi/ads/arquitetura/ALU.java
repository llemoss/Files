package br.edu.ifpi.ads.arquitetura;

public class ALU {

	// 0 - add, 1 - nand, 2 - pass2, 3 - beq
	private byte opcode;

	private Short operand1;
	private Short operand2;
	
	private boolean branch = false;

	public static Short and(Short a, Short b) {
		
		short result = 0;
		for(int i = 0; i < 16; i++){
			boolean bitA = toBitValue(a, i);
			boolean bitB = toBitValue(b, i);
			
			if(bitA && bitB){
				result += 1 << i;
			}
		}
		
		return result;
	}

	public static Short not(Short a) {
		short result = 0;
		for(int i = 0; i < 16; i++){
			boolean bitA = toBitValue(a, i);
			if(!bitA){
				result += 1 << i;
			}
		}
		return result;
	}

	public static Short nand(Short a, Short b) {
		return not(and(a, b));
	}
	
	public static Short sum(Short a, Short b){
		
		boolean carry = false;
		short result = 0;
		
		for (int i = 0; i < 16; i++) {
			
			boolean bitA = toBitValue(a, i);
			boolean bitB = toBitValue(b, i);
			
			if(bitA && bitB){
				if(carry){
					result += 1 << i;
				}
				carry = true;
			}else if(bitA || bitB){
				if(!carry){
					result += 1 << i;
				}
			}else if(carry){
				result += 1 << i;
				carry = false;
			}
			
		}
		
		return result;
	}
	
	public static boolean toBitValue(Short n, int bit) {
		int position = 1 << bit;
		return (n & position) == position;
	}
	
	// TODO resultado da operacao (add, nand, pass2)
	public Short getResult() {
		Short result =  0;
		
		switch(getOpcode()){
			case 0:
				result = sum(operand1, operand2);
				break;
			case 1:
				result = nand(operand1, operand2);
				break;
			case 2:
				result = operand2;
				break;
		}
		
		return result;
	}

	// TODO resultado do branch em operacao beq. Branch: true, sem branch: false
	public boolean isBranch() {
		return (operand1 == operand2);
	}

	public byte getOpcode() {
		return opcode;
	}

	public void setOpcode(byte opcode) {
		this.opcode = opcode;
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

}
