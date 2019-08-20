import java.util.*;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true)
        {
        	int M = sc.nextInt();
            int N = sc.nextInt();
            if(M == 0 && N == 0) break;
            int res = 0;
            int[][] map = new int[M][N];
            int[] dp = new int[M];
            int[] arr = new int[M];
            for(int i = 0; i < M; i++)
            {
            	int max = 0;
            	for(int j = 0; j < N; j++)
            	{
            		map[i][j] = sc.nextInt();
            		if(j - 4 >= 0)
            			map[i][j] = Math.max(map[i][j-2], Math.max(map[i][j-3], map[i][j-4])) + map[i][j];
            		else if(j - 3 >= 0)
            			map[i][j] = Math.max(map[i][j-2], map[i][j-3]) + map[i][j];
            		else if(j - 2 >= 0)
            			map[i][j] = map[i][j-2] + map[i][j];
            		max = Math.max(max, map[i][j]);
            	}
            	arr[i] = max;
            }
            dp[0] = arr[0];
            res = dp[0];
            for(int i = 1; i < M; i++)
            {
            	if(i - 4 >= 0)
        			dp[i] = Math.max(dp[i-4], Math.max(dp[i-2], dp[i-3])) + arr[i];
        		else if(i - 3 >= 0)
        			dp[i] = Math.max(dp[i-2], dp[i-3]) + arr[i];
        		else if(i - 2 >= 0)
        			dp[i] = dp[i-2] + arr[i];
        		else
        			dp[i] = arr[i];
        		res = Math.max(res, dp[i]);
            }
            System.out.println(res);
        }        
    }
}