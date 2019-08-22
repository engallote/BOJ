import java.util.*;

public class Main {
	static ArrayList<Integer>[] arr;
	static int[] chk = new int[1000001], chk2, visit;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		arr = new ArrayList[N];
		visit = new int[N];
		chk2 = new int[N];
		Arrays.fill(chk, -1);
		Arrays.fill(chk2, -1);
		Arrays.fill(visit, -1);
		for(int i = 0; i < N; i++)
		{
			arr[i] = new ArrayList<>();
			int a = sc.nextInt();
			int b = sc.nextInt();
			arr[i].add(a);
			arr[i].add(b);
		}
		int res = 0;
		for(int i = 0; i < N; i++)
		{
			if(dfs(i, i))
				res++;
		}
		if(res == N)
			for(int i = 0; i < N; i++)
				System.out.println(chk2[i]);
		else
			System.out.println(-1);
	}
	private static boolean dfs(int idx, int x) {
		if(visit[idx] == x) return false;
		visit[idx] = x;
		
		for(int next : arr[idx])
		{
			if(chk[next] == -1 || dfs(chk[next], x))
			{
				chk2[idx] = next;
				chk[next] = idx;
				return true;
			}
		}
		return false;
	}
}