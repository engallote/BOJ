import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = sc.nextInt();
			int res = 0;
			for(int j = 2; j <= N; j++)
			{
				int num = N;
				while(num % j == 0)
				{
					res++;
					num /= j;
				}
			}
			System.out.println(res);
		}
	}
}