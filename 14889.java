import java.util.*;

public class Main {
	static int N, res = Integer.MAX_VALUE;
	static int[][] arr;
	static int[] dp;
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new int[N][N];
        dp = new int[1<<N];
        Random rd = new Random();
        
        for(int i = 0; i < N; i++)
        	for(int j = 0; j < N; j++)
        	{
        		arr[i][j] = sc.nextInt();
//        		arr[i][j] = rd.nextInt(101);
        	}
//        for(int i = 0; i < N; i++)
//        {
//        	for(int j = 0; j < N; j++)
//        		System.out.print(arr[i][j] + " ");
//        	System.out.println();
//        }
        for(int i = 0; i < N/2; i++)
        	solve(i, (1<<i), 1);
        
        System.out.println(res);
	}
	private static int sum(int chk) {
		int sum1 = 0, sum2 = 0;
		for(int i = 0; i < N; i++)
		{
			if((chk&(1<<i)) == 0)
			{
				for(int j = 0; j < N; j++)
					if((chk&(1<<j)) == 0 && i != j)
						sum2 += arr[i][j];
			}
			else
			{
				for(int j = 0; j < N; j++)
					if((chk&(1<<j)) != 0 && i != j)
						sum1 += arr[i][j];
			}
		}
		
		return Math.abs(sum1 - sum2);
	}
	private static void solve(int idx, int chk, int cnt) {
		if(cnt == N / 2)
		{
			res = Math.min(res, sum(chk));
			return;
		}
		
		for(int i = idx + 1; i < N; i++)
			solve(i, chk|(1<<i), cnt + 1);
	}
}