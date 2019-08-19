import java.util.*;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        
        for(int test_case = 1; test_case <= tc; test_case++)
        {
        	int N = sc.nextInt();
        	int M = sc.nextInt();
        	
        	int g = gcd(N, M);
        	int lcm = 0;
        	if(g == 1)
        		lcm = N * M;
        	else
        	{
        		int mul = 1;
        		while(true)
        		{
        			int tmp = g * mul;
        			if(tmp % N == 0 && tmp % M == 0)
        			{
        				lcm = tmp;
        				break;
        			}
        			mul++;
        		}
        	}
        	System.out.println(lcm + " " + g);
        }
    }

	private static int gcd(int n, int m) {
		if(m == 0) return n;
		if(m > n)
		{
			int tmp = m;
			m = n;
			n = tmp;
		}
		return gcd(m, n%m);
	}
}