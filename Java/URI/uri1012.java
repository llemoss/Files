import java.util.Scanner;

public class uri1012{
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		float a = scanner.nextFloat();
		scanner.nextLine();
		float b = scanner.nextFloat();
		scanner.nextLine();
		float c = scanner.nextFloat();
		scanner.nextLine();

		System.out.format("TRIANGULO: %.3f\nCIRCULO: %.3f\nTRAPEZIO: %.3f\nQUADRADO: %.3f\nRETANGULO: %.3f", (float)(((a*c)/2.0)), (float)((c*c)*3.14159), (float)(((a+b)*c)/2.0), (float)(b*b), (float)(a*b));
	}
}