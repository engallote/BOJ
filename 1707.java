import java.util.*;

public class Main {
	static int V;
	static int[] visit;
	static ArrayList<ArrayList<Integer>> aly;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		
		for(int t = 0; t < tc; t++)
		{
			V = sc.nextInt();
			int E = sc.nextInt();
			visit = new int[V+1];
			boolean flag = true;
			aly = new ArrayList<>();
			
			for(int i = 0; i <= V; i++)
				aly.add(new ArrayList<>());
			
			for(int i = 0; i < E; i++)
			{
				int a = sc.nextInt();
				int b = sc.nextInt();
				aly.get(a).add(b);
				aly.get(b).add(a);
			}
			
			for(int i = 1; i <= V; i++)
				if(visit[i] == 0)
					dfs(i, 1);
			
			for(int i = 1; i <= V; i++)
				for(int j = 0; j < aly.get(i).size(); j++)
				{
					int n = aly.get(i).get(j);
					if(visit[i] == visit[n])
					{
						flag = false;
						break;
					}
				}
			
			if(flag)
				System.out.println("YES");
			else
				System.out.println("NO");
		}
	}
	private static void dfs(int num, int color) {
		if(visit[num] != 0) return;
		
		visit[num] = color;
		for(int i = 0; i < aly.get(num).size(); i++)
		{
			int n = aly.get(num).get(i);
			if(visit[n] == 0)
				dfs(n, 3 - color);
		}
		
	}
}