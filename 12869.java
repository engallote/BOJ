import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int N, res;
	static boolean flag = false;
	static int[][][] dp = new int[61][61][61];
	static int[][] d = {{9, 3, 1}, {9, 1, 3}, {3, 1, 9}, {3, 9, 1}, {1, 3, 9}, {1, 9, 3}};
	public static void main(String[] args) throws IOException {
//        Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        res = Integer.MAX_VALUE;
        int[] arr = new int[3];
        String[] str = br.readLine().split(" ");
        for(int i = 0; i < N; i++)
        	arr[i] = Integer.parseInt(str[i]);
        
        for(int i = 0; i < 61; i++)
        	for(int j = 0; j < 61; j++)
        		Arrays.fill(dp[i][j], -1);
        
        System.out.println(solve(arr[0], arr[1], arr[2]));
    }
	private static int solve(int a, int b, int c) {
		if(a == 0 && b == 0 && c == 0) return 0;
		int ret = dp[a][b][c];
		if(ret != -1) return ret;
		ret = Integer.MAX_VALUE;
		for(int i = 0; i < 6; i++)
		{
			int aa = Math.max(0, a - d[i][0]);
			int bb = Math.max(0, b - d[i][1]);
			int cc = Math.max(0, c - d[i][2]);
			ret = Math.min(ret, solve(aa, bb, cc) + 1);
		}
		return dp[a][b][c] = ret;
	}
}