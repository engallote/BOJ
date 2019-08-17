import java.util.*;

public class Main {
	static int N, M;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		ArrayList<Pair>[] arr = new ArrayList[N+1];
		for(int i = 1; i <= N; i++)
			arr[i] = new ArrayList<>();
		
		for(int i = 0; i < M; i++)
		{
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			arr[a].add(new Pair(b, c));
			arr[b].add(new Pair(a, c));
		}
		
		int s = sc.nextInt();
		int e = sc.nextInt();
		boolean flag = false;
		boolean[] chk = new boolean[N+1];
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		int l = 1, r = Integer.MAX_VALUE, mid, res = 0;
		while(l <= r)
		{
			mid = (l + r) / 2;
			pq.clear();
			flag = false;
			Arrays.fill(chk, false);
			pq.add(new Pair(s, Integer.MAX_VALUE));
			while(!pq.isEmpty())
			{
				Pair p = pq.poll();
				if(p.v == e)
				{
					flag = true;
					break;
				}
				
				for(Pair next : arr[p.v])
				{
					if(!chk[next.v] && next.c >= mid)
					{
						chk[next.v] = true;
						pq.add(next);
					}
				}
			}
			if(flag)
			{
				res = mid;
				l = mid + 1;
			}
			else r = mid - 1;
		}
		System.out.println(res);
	}
}
class Pair implements Comparable<Pair>{
	int v, c;
	Pair(int v, int c)
	{
		this.v = v;
		this.c = c;
	}
	@Override
	public int compareTo(Pair o) {
		return o.c > this.c ? 1 : -1;
	}
}