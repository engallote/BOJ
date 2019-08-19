import java.math.BigInteger;
import java.util.*;

public class Main {
	static BigInteger[] arr = new BigInteger[100001];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		arr[0] = BigInteger.ZERO;
		arr[1] = BigInteger.ONE;
		arr[2] = BigInteger.ONE;
		
		for(int i = 3; i <= 100000; i++)
		{
			arr[i] = BigInteger.ZERO;
			arr[i] = arr[i].add(arr[i-1].add(arr[i-2]));
		}
		
		int tc = sc.nextInt();
		
		for(int t = 0; t < tc; t++)
		{
			BigInteger N = new BigInteger(sc.next());
			if(N.compareTo(BigInteger.ZERO) == 0)
				System.out.println(0);
			else if(N.compareTo(BigInteger.ONE) == 0)
				System.out.println(2);
			else
			{
				for(int i = 0; i <= 100000; i++)
					if(N.compareTo(arr[i]) == 0)
					{
						System.out.println(i);
						break;
					}
			}
		}
	}
}