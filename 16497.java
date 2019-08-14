import java.util.*;

public class Main {
	static int N, K, res = 0;
	static Pair[] arr;
	static int[][] dp;
	static boolean[] chk;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new Pair[N];
		chk = new boolean[N];
		
		for(int i = 0; i < N; i++)
			arr[i] = new Pair(sc.nextInt(), sc.nextInt());
		
		Arrays.sort(arr);
		
		K = sc.nextInt();
		
		dp = new int[K + 1][N + 1];
		for(int i = 0; i <= K; i++)
			Arrays.fill(dp[i], -1);
		solve(1, 0, 0, 0);
		System.out.println(res);
	}
	private static void solve(int book, int idx, int s, int cnt) {
		if(res == 1) return;
		if(cnt >= N)
		{
			res = 1;
			return;
		}
		if(dp[book][idx] != -1) return;
		for(int i = idx; i < N; i++)
			if(!chk[i] && s <= arr[i].s)
			{
				chk[i] = true;
				solve(book, i + 1, arr[i].e, cnt + 1);
				chk[i] = false;
			}
		if(book + 1 <= K)
			solve(book + 1, 0, 0, cnt);
		dp[book][idx] = 0;
	}
}
class Pair implements Comparable<Pair>{
	int s, e;
	Pair(int s, int e){
		this.s = s;
		this.e = e;
	}
	@Override
	public int compareTo(Pair o) {
		if(o.s > this.s) return -1;
		else if(o.s == this.s)
		{
			if(o.e > this.e) return -1;
			else if(o.e == this.e) return 0;
			else return 1;
		}
		else return 1;
	}
}