import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		
		int res = B - A;
		
		int g = gcd(res, B);
		res /= g;
		B /= g;
		
		System.out.println(res + " " + B);
	}

	private static int gcd(int a, int b) {
		if(b == 0) return a;
		if(a < b)
		{
			int tmp = a;
			a = b;
			b = tmp;
		}
		return gcd(b, a % b);
	}
}