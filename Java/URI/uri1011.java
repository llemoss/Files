import java.util.Scanner;

public class uri1011{
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		int raio = scanner.nextInt();
		float volume = (float)(3.14159 * raio * raio * raio * (4.0/3));
		System.out.format("VOLUME = %.3f", volume);
	}
}