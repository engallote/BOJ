import java.util.*;
 
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[][] chk = new int[N+1][N+1];
        for(int i = 0; i <= N; i++)
        	Arrays.fill(chk[i], 1000000000);
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
        int s = sc.nextInt();
        int e = sc.nextInt();
        String[] ans = new String[1001];
        int res = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(s, 0, s + " "));
        chk[s][s] = 0;
        while(!pq.isEmpty())
        {
        	Pair p = pq.poll();
        	if(p.v == e)
        	{
        		res = p.cost;
        		ans = p.str.split(" ");
        		break;
        	}
        	for(int i = 0; i < arr[p.v].size(); i++)
        	{
        		Pair next = arr[p.v].get(i);
        		if(chk[p.v][next.v] >= p.cost + next.cost)
        		{
        			chk[p.v][next.v] = p.cost + next.cost;
        			pq.add(new Pair(next.v, p.cost + next.cost, p.str + next.v + " "));
        		}
        	}
        }
        System.out.println(res);
        System.out.println(ans.length);
        for(int i = 0; i < ans.length; i++)
        	System.out.print(ans[i] + " ");
    }
}
class Pair implements Comparable<Pair>{
	int v, cost;
	String str;
	Pair(int v, int cost)
	{
		this.v = v;
		this.cost = cost;
	}
	Pair(int v, int cost, String str)
	{
		this.v = v;
		this.cost = cost;
		this.str = str;
	}
	@Override
	public int compareTo(Pair o) {
		return o.cost > this.cost ? -1 : 1;
	}
}