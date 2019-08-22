import java.util.*;

public class Main {
	static int N, tmp = 0, max = 0;
	static ArrayList<Pair>[] arr;
	static boolean[] visit;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new ArrayList[N+1];
		visit = new boolean[N+1];
		for(int i = 1; i <= N; i++)
		{
			int root = sc.nextInt();
			arr[root] = new ArrayList<>();
			
			while(true)
			{
				int x = sc.nextInt();
				if(x == -1) break;
				int w = sc.nextInt();
				
				arr[root].add(new Pair(x, w));
			}
		}
		visit[1] = true;
		dfs(1, 0);
		Arrays.fill(visit, false);
		visit[tmp] = true;
		dfs(tmp, 0);
		System.out.println(max);
	}
	private static void dfs(int root, int sum) {
		if(sum > max)
		{
			max = sum;
			tmp = root;
		}
		
		for(int i = 0; i < arr[root].size(); i++)
		{
			Pair p = arr[root].get(i);
			if(!visit[p.x])
			{
				visit[p.x] = true;
				dfs(p.x, sum + p.w);
				visit[p.x] = false;
			}
		}
	}
}
class Pair{
	int x, w;
	Pair(int x, int w){
		this.x = x;
		this.w = w;
	}
}