package ativ2601.forca;

public class Forca {

	private static Forca unico;
	static Rodada[] rodadas = new Rodada[10];
	
	private Forca(){}
	
	public static Forca getInstance(){
		if (unico == null){
			unico = new Forca();
		}
		return unico;
	}

}
