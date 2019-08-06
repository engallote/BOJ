import java.util.*;

public class Main {
	static int N, res;
	static boolean[] chk;
	static Pair[] arr;
	static ArrayList<Integer>[] aly = new ArrayList[366];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true)
		{
			N = sc.nextInt();
			if(N == 0) break;
			arr = new Pair[N];
			chk = new boolean[366];
			res = 0;
			
			for(int i = 0; i <= 365; i++)
				aly[i] = new ArrayList<>();
			
			for(int i = 0; i < N; i++)
			{
				int a = sc.nextInt();
				int b = sc.nextInt();
				int c = sc.nextInt();
				arr[i] = new Pair(a, b, c);
				aly[a].add(i);
			}
//			Arrays.sort(arr);
			
			solve(1, 1, 0);
			System.out.println(res);
//			System.out.println("=============");
		}
	}
	private static void solve(int room, int start, int cost) {
		if(room > 2) return;
		if(start > 365) solve(room + 1, 1, cost);
		res = Math.max(res, cost);
		for(int i = start; i <= 365; i++)
		{
			for(int next : aly[i])
				if(!chk[next])
				{
//					System.out.print(">>>> "+ i + ", " +  next + ", ");
//					System.out.println(room + " : " + arr[next].s + " ~ " + arr[next].e + ", " + arr[next].cost + " + " + cost);
					chk[next] = true;
					solve(room, arr[next].e + 1, cost + arr[next].cost);
//					solve(room + 1, arr[next].e + 1, cost + arr[next].cost);
					chk[next] = false;
				}
		}
		solve(room + 1, 1, cost);
	}
}
class Pair implements Comparable<Pair>{
	int s, e, cost;
	Pair(int s, int e, int cost){
		this.s = s;
		this.e = e;
		this.cost = cost;
	}
	@Override
	public int compareTo(Pair o) {
		if(o.s > this.s) return -1;
		else if(o.s == this.s)
		{
			if(o.e > this.e) return -1;
			else if(o.e == this.e)
			{
				if(o.cost > this.cost) return 1;
				else if(o.cost == this.cost) return 0;
				else return -1;
			}
			else return 1;
		}
		else return 1;
	}
}