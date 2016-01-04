import java.util.Scanner;

public class exercicio6{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		int n=0, qt=0, c=0, r=0, s=0, i=0, q=0;
		char t;
		n = input.nextInt();
		while(i<n){
			q = input.nextInt();
			t = input.next().charAt(0);
			qt += q;
			if(t=='C'){c+=q;}
			if(t=='R'){r+=q;}
			if(t=='S'){s+=q;}
			i++;}
		System.out.format("Total: %d cobaias\nTotal de coelhos: %d\nTotal de ratos: %d\nTotal de sapos: %d\n", qt, c, r, s);
		double a = (double)(c*(100/qt));
		double b = (double)(r*(100/qt));
		double d = (double)(s*(100/qt));
		System.out.format("Percentual de coelhos: %.2f %%\nPercentual de ratos: %.2f %%\nPercentual de sapos: %.2f %%", a, b, d);
	}
}
