import java.util.*;

public class Main {
	static int K, N, F, end = 0;
	static int[][] arr;
	static boolean[] visit;
	static Vector<Integer> v = new Vector<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		K = sc.nextInt();
		N = sc.nextInt();
		F = sc.nextInt();
		arr = new int[N+1][N+1];
		
		for(int i = 0; i < F; i++)
		{
			int a = sc.nextInt();
			int b = sc.nextInt();
			arr[a][b] = arr[b][a] = 1;
		}
		
		for(int i = 1; i <= N; i++)
		{
			visit = new boolean[N+1];
			v.clear();
			dfs(i);
			if(end == 1)
				break;
		}
		
		if(end == 1)
		{
			v.sort(null);
			for(int i : v)
				System.out.println(i);
		}
		else
			System.out.println(-1);
	}
	private static void dfs(int num) {
		if(end == 1) return;
		
		visit[num] = true;
		v.addElement(num);
		if(v.size() == K)
		{
			end = 1;
			return;
		}
		else
		{
			for(int i = num; i <= N; i++)
			{
				if(arr[num][i] == 1 && !visit[i])
				{
					boolean flag = true;
					for(int j = 0; j < v.size(); j++)
					{
						if(arr[i][v.get(j)] == 0)
						{
							flag = false;
							break;
						}
					}
					if(flag) dfs(i);
				}
			}	
		}
	}
}