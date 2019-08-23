import java.util.*;

public class Main {
	static int N, M;
	static int[] cow;
	static boolean[][] arr;
	static boolean[] visit;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		cow = new int[M+1];
		arr = new boolean[N][M+1];
		visit = new boolean[N];
		Arrays.fill(cow, -1);
		
		for(int i = 0; i < N; i++)
		{
			int num = sc.nextInt();
			for(int j = 0; j < num; j++)
				arr[i][sc.nextInt()] = true;
		}
		
		int line = 0;
		for(int i = 0; i < N; i++)
		{
			Arrays.fill(visit, false);
			if(dfs(i))
				line++;
		}
		
		System.out.println(line);
	}
	private static boolean dfs(int idx) {
		if(visit[idx]) return false;
		visit[idx] = true;
		
		for(int i = 1; i <= M; i++)
			if(arr[idx][i] && (cow[i] == -1 || dfs(cow[i])))
			{
				cow[i] = idx;
				return true;
			}
		return false;
	}
}