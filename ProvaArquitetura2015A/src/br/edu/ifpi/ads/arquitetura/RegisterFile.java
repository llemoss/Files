package br.edu.ifpi.ads.arquitetura;

public class RegisterFile {
	
	private byte target;
	private byte source1;
	private byte source2;
	
	boolean we;
	
	private Short[] RF = {0, 0, 0, 0, 0, 0, 0};
	
	public void setTarget(byte target) {
		this.target = target;
	}
	public void setSource1(byte source1) {
		this.source1 = source1;
	}
	public void setSource2(byte source2) {
		this.source2 = source2;
	}
	
	// TODO
	public Short getSourceValue1() {
		return RF[source1];
	}
	
	// TODO
	public Short getSourceValue2() {
		return RF[source2];
	}
	
	// TODO
	public void setTargetValue(Short value) {
		if(we && target != 0) RF[target] = value;
	}
	
	// TODO
	public void setWriteEnabled(boolean enabled){
		this.we = enabled;
	}

}
