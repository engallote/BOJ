import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		int D = sc.nextInt();
		
		int mok = D / 60;
		int mod = D % 60;
		
		C += mod;
		if(C >= 60)
		{
			C %= 60;
			mok++;
		}
		B += mok;
		mok = 0;
		if(B >= 60)
		{
			mok = B / 60;
			B %= 60;
		}
		A += mok;
		if(A >= 24)
			A %= 24;
		
		System.out.println(A + " " + B + " " + C);
	}
}