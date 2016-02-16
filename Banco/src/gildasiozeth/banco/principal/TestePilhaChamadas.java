package gildasiozeth.banco.principal;

public class TestePilhaChamadas {

	public static void main(String[] args) {
		System.out.println("Inicio do main()");
		m1();
		System.out.println("Final do main()");
	}

	private static void m1() {
		System.out.println("Inicio m1()");
		
		try{m2();
		}catch(Exception e){
			System.out.println("Ocorreu um erro!");
			e.printStackTrace();
		}
		
		System.out.println("Fim m1()");
	}

	private static void m2() {
		System.out.println("Inicio m2()");
		int numeros[] = new int[5];
		for (int i = 0; i < numeros.length+1; i++) {
			numeros[i] = i*4;
			System.out.println(numeros[i]);
		}
		System.out.println("Fim m2()");		
	}

}
