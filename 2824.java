import java.math.BigInteger;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		BigInteger A = new BigInteger("1"), B = new BigInteger("1");
		
		for(int i = 0; i < N; i++)
			A = A.multiply(new BigInteger(sc.next()));
		
		int M = sc.nextInt();
		for(int i = 0; i < M; i++)
			B = B.multiply(new BigInteger(sc.next()));
		
		BigInteger res = gcd(A, B);
		if(res.toString().length() > 9)
			System.out.println(res.toString().substring(res.toString().length() - 9));
		else
			System.out.println(res);
	}
	private static BigInteger gcd(BigInteger a, BigInteger b) {
		if(a.compareTo(b) == -1)
		{
			BigInteger tmp = a;
			a = b;
			b = tmp;
		}
		if(b.compareTo(BigInteger.ZERO) == 0)
			return a;
		return gcd(b, a.mod(b));
	}
}