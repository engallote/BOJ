import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		long res = fac(N);
		System.out.println(res);
	}

	private static long fac(int n) {
		long mul = 1;
		for(int i = n; i >= 2; i--)
		{
			mul *= i;
			mul %= 1000000000;
			while(mul % 10 == 0)
				mul /= 10;
//			System.out.println(mul);
		}
		return (mul % 10);
	}
}