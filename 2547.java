import java.math.BigInteger;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = sc.nextInt();
			BigInteger res = BigInteger.ZERO;
			for(int i = 0; i < N; i++) res = res.add(new BigInteger(sc.next()));
			
			if(res.mod(new BigInteger(Integer.toString(N))).compareTo(BigInteger.ZERO) == 0) 
				System.out.println("YES");
			else System.out.println("NO");
		}
	}
}