/*print "Ex. 6"
N = input()
QT = 0
C = 0
R = 0
S = 0
i = 0
while i < N:
	Q, T = [str(g) for g in raw_input("").split(" ")]
	Q = int(Q)
	QT = QT + Q
	if T == "C":
		C = C + Q
	if T == "R":
		R = R + Q
	if T == "S":
		S = S + Q
	i = i + 1

print "Total: %d cobaias" % QT
print "Total de coelhos: %d" % C
print "Total de ratos: %d" % R
print "Total de sapos: %d" % S
C = float(C)
R = float(R)
S = float(S)
QT = float(QT)
C = C*100/QT
R = R*100/QT
S = S*100/QT
print "Percentual de coelhos: %.2f %%" % C
print "Percentual de ratos: %.2f %%" % R
print "Percentual de sapos: %.2f %%" % S*/

import java.util.Scanner;

public class exercicio6{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		int n=0, qt=0, c=0, r=0, s=0, i=0, q=0;
		String t;
		n = input.nextInt();
		while(i<n){
			q = input.nextInt();
			input.nextLine();
			t = input.nextLine();
			//input.nextLine();
			//System.out.format("Animal: %s", t);
			qt += q;
			if(t=="C"){c+=q;}
			if(t=="R"){r+=q;}
			if(t=="S"){s+=q;}
			i++;}
		System.out.format("Total: %d cobaias\nTotal de coelhos: %d\nTotal de ratos: %d\nTotal de sapos: %d\n", qt, c, r, s);
		float a = (float)(c*(100/qt));
		float b = (float)(r*(100/qt));
		float d = (float)(s*(100/qt));
		System.out.format("Percentual de coelhos: %.2f %%\nPercentual de ratos: %.2f %%\nPercentual de sapos: %.2f %%", a, b, d);
	}
}
