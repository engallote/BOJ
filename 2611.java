import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		ArrayList<Pair>[] arr = new ArrayList[N+1];
		for(int i = 1; i <= N; i++)
			arr[i] = new ArrayList<>();
		
		for(int i = 0; i < M; i++)
		{
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			arr[a].add(new Pair(b, c));
		}
		
		for(int i = 1; i <= N; i++)
			Collections.sort(arr[i]);
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		pq.add(new Pair(1, 0, "1 "));
		boolean[][] pass = new boolean[N+1][N+1];
		int[] chk = new int[N+1];
		chk[1] = -1;
		int res = 0;
		String path = "";
		while(!pq.isEmpty())
		{
			Pair p = pq.poll();
//			System.out.println(p.v + " " + p.c + " " + p.str);
			if(p.v == 1 && chk[p.v] > -1)
			{
				if(res < p.c)
				{
					res = p.c;
					path = p.str.trim();
				}
				continue;
			}
			
			for(Pair next : arr[p.v])
			{
				if(chk[next.v] <= p.c + next.c)
				{
					chk[next.v] = p.c + next.c;
					pq.add(new Pair(next.v, chk[next.v], p.str + next.v + " "));
				}
			}
		}
		System.out.println(res);
		System.out.println(path);
	}
}
class Pair implements Comparable<Pair>{
	int v, c;
	String str;
	Pair(int v, int c)
	{
		this.v = v;
		this.c = c;
	}
	Pair(int v, int c, String str)
	{
		this.v = v;
		this.c = c;
		this.str = str;
	}
	@Override
	public int compareTo(Pair o) {
		return o.c > this.c ? 1 : -1;
	}
}