import java.util.*;
 
public class Main {
	static final int R = 0, G = 1, B = 2;
	static int N, M, K;
	static int[] arr;
	static int[][] dp;
	static ArrayList<Pair>[] aly;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new int[N];
        for(int i = 0; i < N; i++)
        {
        	char c = sc.next().charAt(0);
        	if(c == 'R') arr[i] = R;
        	else if(c == 'G') arr[i] = G;
        	else arr[i] = B;
        }
        
        M = sc.nextInt();
        K = sc.nextInt();
        dp = new int[M+1][N];
        aly = new ArrayList[M+1];
        for(int i = 1; i <= M; i++)
        {
        	Arrays.fill(dp[i], -1);
        	aly[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < K; i++)
        {
        	int a = sc.nextInt();
        	int b = sc.nextInt();
        	char c = sc.next().charAt(0);
        	
        	if(c == 'R')
        	{
        		aly[a].add(new Pair(b, R));
        		aly[b].add(new Pair(a, R));
        	}
        	else if(c == 'G')
        	{
        		aly[a].add(new Pair(b, G));
        		aly[b].add(new Pair(a, G));
        	}
        	else
        	{
        		aly[a].add(new Pair(b, B));
        		aly[b].add(new Pair(a, B));
        	}
        }
        int res = dfs(1, 0);
        System.out.println(res);
    }
	private static int dfs(int idx, int cnt) {
		if(cnt == N) return 0;
		if(dp[idx][cnt] != -1) return dp[idx][cnt];
		
		int ret = 0;
		
		for(Pair next : aly[idx])
		{
			if(next.c == arr[cnt])
				ret = Math.max(ret, dfs(next.v, cnt + 1) + 10);
			else
				ret = Math.max(ret, dfs(next.v, cnt + 1));
		}
		return dp[idx][cnt] = ret;
	}
}
class Pair{
	int v, c, cnt;
	Pair(int v, int c)
	{
		this.v = v;
		this.c = c;
	}
}