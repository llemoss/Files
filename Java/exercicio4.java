import java.util.Scanner;

public class exercicio4{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		int n, i, count;
		n = input.nextInt();
		i = n*4;
		int[] v = new int[i+1];
		for(int a=1;a<i;a++){v[a] = a;}
		count = 0;
		while(count<i){
			System.out.format("%d %d %d IFPI\n", v[count+1], v[count+2], v[count+3]);
			count+=4;
		}
	}
}