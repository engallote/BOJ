import java.math.BigInteger;
import java.util.*;

public class Main {
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		BigInteger[] dp = new BigInteger[N+1];
		
		if(N == 0)
			System.out.println(1);
		else if(N == 1)
			System.out.println(1);
		else if(N == 2)
			System.out.println(1);
		else
		{
			dp[0] = new BigInteger("0");
			dp[1] = new BigInteger("1");
			dp[2] = new BigInteger("1");
			
			for(int i = 3; i <= N; i++)
			{
				dp[i] = dp[i-2].add(dp[i-1]);
			}
			
			System.out.println(dp[N].toString());
		}
	}
}