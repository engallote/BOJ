import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
	static int N, W;
	static int[] arr;
	static int[][][] dp;
	public static void main(String[] args) throws IOException {
//		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		arr = new int[N+1];
		dp = new int[3][W+1][N+1];
		for(int i = 1; i <= N; i++)
			arr[i] = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < 3; i++)
			for(int j = 0; j <= W; j++)
				Arrays.fill(dp[i][j], -1);
		int res = Math.max(solve(1, 0, 1), solve(2, 1, 1));
		bw.write(res+"");
		bw.flush();
	}
	private static int solve(int tree, int move, int time) {
		if(time > N || move > W) return 0;
		if(dp[tree][move][time] != -1) return dp[tree][move][time];
		int ret = 0, get = arr[time] == tree ? 1 : 0;
		
		ret = Math.max(ret, solve(tree, move, time + 1) + get);
		ret = Math.max(ret, solve(tree == 1 ? 2 : 1, move + 1, time + 1) + get);
		return dp[tree][move][time] = ret;
	}
}