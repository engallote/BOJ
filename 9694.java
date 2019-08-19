import java.util.*;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        for(int test_case = 1; test_case <= tc; test_case++)
        {
        	int N = sc.nextInt();
        	int M = sc.nextInt();
        	ArrayList<Pair>[] arr = new ArrayList[M];
        	for(int i = 0; i < M; i++)
        		arr[i] = new ArrayList<>();
        	
        	for(int i = 0; i < N; i++)
        	{
        		int a = sc.nextInt();
        		int b = sc.nextInt();
        		int c = sc.nextInt();
        		arr[a].add(new Pair(b, c));
        		arr[b].add(new Pair(a, c));
        	}
        	
        	for(int i = 0; i < M; i++)
        		Collections.sort(arr[i]);
        	
        	String res = "-1";
        	PriorityQueue<Pair> pq = new PriorityQueue<>();
        	int[] visit = new int[M];
        	Arrays.fill(visit, Integer.MAX_VALUE);
        	visit[0] = 0;
        	pq.add(new Pair(0, 0, "0 "));
        	while(!pq.isEmpty())
        	{
        		Pair p = pq.poll();
        		if(p.v == M - 1)
        		{
        			res = p.str;
        			break;
        		}
        		for(Pair next : arr[p.v])
        			if(visit[next.v] > p.c + next.c)
        			{
        				visit[next.v] = p.c + next.c;
        				pq.add(new Pair(next.v, p.c + next.c, p.str + next.v + " "));
        			}
        	}
        	System.out.println("Case #" + test_case + ": " + res);
        }
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
		return o.c > this.c ? -1 : 1;
	}
}