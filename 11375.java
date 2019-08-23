import java.util.*;

public class Main {
	static int N, M;
	static int[] chk;
	static boolean[][] arr;
	static boolean[] visit;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		chk = new int[M+1];
		arr = new boolean[N][M+1];
		visit = new boolean[N];
		
		Arrays.fill(chk, -1);
		
		for(int i = 0; i < N; i++)
		{
			int num = sc.nextInt();
			for(int j = 0; j < num; j++)
				arr[i][sc.nextInt()] = true;
		}
		
		int cnt = 0;
		for(int i = 0; i < N; i++)
		{
			Arrays.fill(visit, false);
			if(dfs(i))
				cnt++;
		}
		System.out.println(cnt);
	}
	private static boolean dfs(int idx) {
		if(visit[idx]) return false;
		visit[idx] = true;
		
		for(int i = 1; i <= M; i++)
			if(arr[idx][i] && (chk[i] == -1 || dfs(chk[i])))
			{
				chk[i] = idx;
				return true;
			}
		return false;
	}
}