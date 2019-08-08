import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = sc.nextInt();
			String[] str = new String[N];
			for(int i = 0; i < N; i++)
				str[i] = sc.next();
			
			int M = sc.nextInt();
			String[] ans = new String[M];
			StringBuilder sb;
			for(int i = 0; i < M; i++)
			{
				int k = sc.nextInt();
				sb = new StringBuilder();
				for(int j = 0; j < k; j++)
					sb.append(str[sc.nextInt()]);
				ans[i] = sb.toString();
			}
			System.out.println("Scenario #" + test_case + ":");
			for(int i = 0; i < M; i++)
				System.out.println(ans[i]);
			System.out.println();
		}
	}
}