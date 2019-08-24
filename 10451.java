import java.util.*;

public class Main {
	static int N;
	static int[] arr;
	static boolean[] visit;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		
		for(int t = 0; t < tc; t++)
		{
			N = sc.nextInt();
			arr = new int[N+1];
			visit = new boolean[N+1];
			int cnt = 0;
			for(int i = 1; i <= N; i++)
				arr[i] = sc.nextInt();
			
			for(int i = 1; i <= N; i++)
				if(!visit[i])
				{
					dfs(i);
					cnt++;
				}
			System.out.println(cnt);
		}
	}
	private static void dfs(int x) {
		
		int num = arr[x];
		if(!visit[num])
		{
			visit[num] = true;
			dfs(num);
		}
	}
}