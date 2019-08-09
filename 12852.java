import java.util.*;

public class Main {
	static Vector<Integer> v = new Vector<>();
	static int cnt;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		v.add(N);
		Queue<Integer> q = new LinkedList<>();
		cnt = 0;
		int res = Integer.MAX_VALUE-1;
		dfs(N - 1);
		for(int i : v)
			q.add(i);
		res = Math.min(res, cnt);
		if(N % 2 == 0)
		{
			v.clear();
			v.add(N);
			cnt = 0;
			dfs(N / 2);
			if(res > cnt)
			{
				res = cnt;
				q.clear();
				for(int i : v)
					q.add(i);
			}
		}
		if(N % 3 == 0)
		{
			v.clear();
			v.add(N);
			cnt = 0;
			dfs(N / 3);
			if(res > cnt)
			{
				res = cnt;
				q.clear();
				for(int i : v)
					q.add(i);
			}
		}
		
		System.out.println(res);
		while(!q.isEmpty())
			System.out.print(q.poll() + " ");
	}
	private static void dfs(int x) {
		cnt++;
		v.add(x);
		if(x == 1) return;
		if(x % 3 == 0)
			dfs(x / 3);
		else if(x % 2 == 0)
			dfs(x / 2);
		else
			dfs(x - 1);
	}
}