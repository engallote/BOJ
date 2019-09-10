import java.util.*;

public class Main {
	static int N, M;
	static int[][] arr;
	static int[] chk;
	static boolean[] visit;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			N = sc.nextInt();
			M = sc.nextInt();
			arr = new int[M][2];
			chk = new int[N+1];
			visit = new boolean[M];
			Arrays.fill(chk, -1);
			int res = 0;
			
			for(int i = 0; i < M; i++)
			{
				arr[i][0] = sc.nextInt();
				arr[i][1] = sc.nextInt();
			}
			
			for(int i = 0; i < M; i++)
			{
				Arrays.fill(visit, false);
				if(dfs(i)) res++;
			}
			System.out.println(res);
		}
	}
	private static boolean dfs(int idx) {
		if(visit[idx]) return false;
		visit[idx] = true;
		
		for(int i = arr[idx][0]; i <= arr[idx][1]; i++)
		{
			if(chk[i] == -1 || dfs(chk[i]))
			{
				chk[i] = idx;
				return true;
			}
		}
		return false;
	}
}