import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int A = 0, B = 0, C = 0;
		int mod = N % 60;
		if(mod % 10 != 0)
		{
			System.out.println(-1);
			return;
		}
		int mok = N / 60;
//		System.out.println(mok + " " + mod);
		if(mok >= 5)
		{
			A = mok / 5;
			mok %= 5;
		}
		if(mok >= 1 && mok < 5)
		{
			B += mok;
			mok = 0;
		}
		C = mod / 10;
		mod %= 10;
		
		System.out.println(A + " " + B + " " + C);
	}
}