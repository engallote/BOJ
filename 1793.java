import java.math.BigInteger;
import java.util.*;

public class Main {
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext())
		{
			String n = sc.next();
			
			if(n.length() == 0) break;
			
			int N = Integer.parseInt(n);
			BigInteger[] dp = new BigInteger[N+1];
			
			if(N == 0)
				System.out.println(1);
			else if(N == 1)
				System.out.println(1);
			else
			{
				dp[0] = new BigInteger("1");
				dp[1] = new BigInteger("1");
				dp[2] = new BigInteger("3");
				
				for(int i = 3; i <= N; i++)
				{
					dp[i] = dp[i-2].multiply(new BigInteger("2"));
					dp[i] = dp[i].add(dp[i-1]);
				}
				
				System.out.println(dp[N].toString());
			}
			
		}
	}
}