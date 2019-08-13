import java.util.*;

public class Main {
	static int N, M, K1, K2;
	static ArrayList<Integer>[] arr1, arr2;
	static int[] chk;
	static boolean[] visit;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		K1 = sc.nextInt();
		K2 = sc.nextInt();
		int a = 0, b = 0;
		chk = new int[M+1];
		Arrays.fill(chk, -1);
		visit = new boolean[N+1];
		arr1 = new ArrayList[N+1];
		arr2 = new ArrayList[N+1];
		for(int i = 1; i <= N; i++)
		{
			arr1[i] = new ArrayList<>();
			arr2[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < K1; i++)
		{
			int num = sc.nextInt();
			int pick = sc.nextInt();
			arr1[num].add(pick);
		}
		for(int i = 0; i < K2; i++)
		{
			int num = sc.nextInt();
			int pick = sc.nextInt();
			arr2[num].add(pick);
		}
		
		for(int i = 1; i <= N; i++)
		{
			Arrays.fill(visit, false);
			if(dfs(i, 1)) a++;
		}
		
		Arrays.fill(chk, -1);
		for(int i = 1; i <= N; i++)
		{
			Arrays.fill(visit, false);
			if(dfs(i, 2)) b++;
		}
		
		if(a >= b) System.out.println("그만 알아보자");
		else System.out.println("네 다음 힐딱이");
	}
	private static boolean dfs(int idx, int team) {
		if(visit[idx]) return false;
		visit[idx] = true;
		
		if(team == 1)
		{
			for(int next : arr1[idx])
				if(chk[next] == -1 || dfs(chk[next], team))
				{
					chk[next] = idx;
					return true;
				}
		}
		else
		{
			for(int next : arr2[idx])
				if(chk[next] == -1 || dfs(chk[next], team))
				{
					chk[next] = idx;
					return true;
				}
		}
		return false;
	}
}