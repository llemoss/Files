import java.util.Scanner;

public class uri1036{
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		double a = scanner.nextDouble();
		scanner.nextLine();
		double b = scanner.nextDouble();
		scanner.nextLine();
		double c = scanner.nextDouble();
		scanner.nextLine();

		float delta = (float)(b*b - (4*a*c));

		if(delta > 0){
		double r1 = (double)((-b + Math.sqrt(delta)) / (2.0 * a));
		double r2 = (double)((-b - Math.sqrt(delta)) / (2.0 * a));
		System.out.format("R1 = %.5f\nR2 = %.5f", r1, r2);}
		else{
			System.out.println("Impossivel calcular");
		}
	}
}