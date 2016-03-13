package br.edu.ifpi.ads.test;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import br.edu.ifpi.ads.ALU;
import br.edu.ifpi.ads.OperationCode;

public class Testes {

	boolean[] zero = {false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false};
	boolean[] one = {false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,true};
	boolean[] ten = {false,false,false,false,false,false,false,false,false,false,false,false,true,false,true,false};
	boolean[] eleven = {false,false,false,false,false,false,false,false,false,false,false,false,true,false,true,true};
	
	boolean[] allOnes = {true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true};
	
	private static ALU alu = new ALU();
	private static byte correct = 0;
	
	@BeforeClass
	public static void InitScore(){
		correct = 0;
	}
	
	@AfterClass
	public static void ShowScore(){
		System.out.println("Nota: " + correct + "/8");
	}
	
	@Test
	public void testAdd1() {
		alu.setOperand1(zero);
		alu.setOperand2(zero);
		boolean[] result = alu.execute(OperationCode.ADD);
		Assert.assertArrayEquals(zero, result);
		correct++;
	}
	
	@Test
	public void testAdd2() {
		alu.setOperand1(zero);
		alu.setOperand2(one);
		boolean[] result = alu.execute(OperationCode.ADD);
		Assert.assertArrayEquals(one, result);
		correct++;
	}
	
	@Test
	public void testAdd3() {
		alu.setOperand1(ten);
		alu.setOperand2(one);
		boolean[] result = alu.execute(OperationCode.ADD);
		Assert.assertArrayEquals(eleven, result);
		correct++;
	}
	
	@Test
	public void testBeqTaken1() {
		alu.setOperand1(zero);
		alu.setOperand2(zero);
		alu.execute(OperationCode.BEQ);
		Assert.assertEquals(true, alu.isBranchTaken());
		correct++;
	}
	
	@Test
	public void testBeqTaken2() {
		alu.setOperand1(ten);
		alu.setOperand2(ten);
		alu.execute(OperationCode.BEQ);
		Assert.assertEquals(true, alu.isBranchTaken());
		correct++;
	}
	
	@Test
	public void testBeqNotTaken() {
		alu.setOperand1(ten);
		alu.setOperand2(eleven);
		alu.execute(OperationCode.BEQ);
		Assert.assertEquals(false, alu.isBranchTaken());
		correct++;
	}
	
	@Test
	public void testPass1() {
		alu.setOperand1(ten);
		alu.setOperand2(one);
		boolean[] result = alu.execute(OperationCode.PASS1);
		Assert.assertArrayEquals(ten, result);
		correct++;
	}
	
	@Test
	public void testNand() {
		alu.setOperand1(ten);
		alu.setOperand2(one);
		boolean[] result = alu.execute(OperationCode.NAND);
		Assert.assertArrayEquals(allOnes, result);
		correct++;
	}
	
}
