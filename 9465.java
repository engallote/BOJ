import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
	static int N;
	static int[][] arr;
	static long[][] dp;
	public static void main(String[] args) throws IOException {
//		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int tc = Integer.parseInt(br.readLine());
		for(int t = 0; t < tc; t++)
		{
			N = Integer.parseInt(br.readLine());
			arr = new int[2][N+1];
			dp = new long[2][N+1];
			for(int i = 0; i < 2; i++)
			{
				Arrays.fill(dp[i], -1);
				st = new StringTokenizer(br.readLine());
				for(int j = 1; j <= N; j++)
					arr[i][j] = Integer.parseInt(st.nextToken());
			}
			
			dp[0][1] = arr[0][1];
			dp[1][1] = arr[1][1];
			
			for(int i = 2; i <= N; i++)
			{
				dp[0][i] = Math.max(dp[0][i-2], Math.max(dp[1][i-1], dp[1][i-2])) + arr[0][i];
				dp[1][i] = Math.max(dp[1][i-2], Math.max(dp[0][i-1], dp[0][i-2])) + arr[1][i];
			}
			bw.write(Math.max(dp[0][N], dp[1][N])+"\n");
		}
		bw.flush();
	}
}