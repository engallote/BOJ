import java.util.*;

public class Main {
	static Queue<String> q = new LinkedList<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			int g = gcd(N, M);
			if(g == 1) System.out.println(N * M);
			else
			{
				int cnt = 1;
				while(true)
				{
					int x = g * cnt;
					if(x % N == 0 && x % M == 0)
					{
						System.out.println(x);
						break;
					}
					cnt++;
				}
			}
		}
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