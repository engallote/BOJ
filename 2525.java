import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		
		int mok = C / 60;
		int mod = C % 60;
		
		B += mod;
		if(B >= 60)
		{
			B %= 60;
			mok++;
		}
		A += mok;
		if(A >= 24)
			A %= 24;
		
		System.out.println(A + " " + B);
	}
}