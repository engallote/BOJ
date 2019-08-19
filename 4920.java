import java.util.*;

public class Main {
	static int N;
	static long res;
	static long[][] arr;
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = 1;
        while(true)
        {
        	N = sc.nextInt();
        	if(N == 0) break;
        	arr = new long[N][N];
        	res = Long.MIN_VALUE;
        	
        	for(int i = 0; i < N; i++)
        		for(int j = 0; j < N; j++)
        			arr[i][j] = sc.nextLong();
        	
        	for(int i = 0; i < N; i++)
        		for(int j = 0; j < N; j++)
        			res = Math.max(res, solve(i, j));
        	System.out.println(tc + ". " + res);
        	tc++;
        }
	}
	private static long solve(int r, int c) {
		//l
		long sum = Long.MIN_VALUE, tmp = 0;
		if(r + 3 < N)
		{
			tmp = arr[r][c] + arr[r+1][c] + arr[r+2][c] + arr[r+3][c];
			sum = Math.max(sum, tmp);
		}
		if(c + 3 < N)
		{
			tmp = arr[r][c] + arr[r][c+1] + arr[r][c+2] + arr[r][c+3];
			sum = Math.max(sum, tmp);
		}
		//L
		if(r + 1 < N && c + 2 < N)
		{
			tmp = arr[r][c] + arr[r][c+1] + arr[r][c+2] + arr[r+1][c+2];
			sum = Math.max(sum, tmp);
			tmp = arr[r][c] + arr[r+1][c] + arr[r+1][c+1] + arr[r+1][c+2];
			sum = Math.max(sum, tmp);
		}
		if(r + 2 < N && c - 1 >= 0)
		{
			tmp = arr[r][c] + arr[r+1][c] + arr[r+2][c] + arr[r+2][c-1];
			sum = Math.max(sum, tmp);
		}
		if(r + 2 < N && c + 1 < N)
		{
			tmp = arr[r][c] + arr[r][c+1] + arr[r+1][c] + arr[r+2][c];
			sum = Math.max(sum, tmp);
		}
		//z
		if(r + 1 < N && c + 2 < N)
		{
			tmp = arr[r][c] + arr[r][c+1] + arr[r+1][c+1] + arr[r+1][c+2];
			sum = Math.max(sum, tmp);
		}
		if(r + 2 < N && c - 1 >= 0)
		{
			tmp = arr[r][c] + arr[r+1][c] + arr[r+1][c-1] + arr[r+2][c-1];
			sum = Math.max(sum, tmp);
		}
//		if(r + 1 < N && c - 1 >= 0 && c + 1 < N)
//		{
//			tmp = arr[r][c] + arr[r+1][c] + arr[r+1][c-1] + arr[r][c+1];
//			sum = Math.max(sum, tmp);
//		}
//		if(r + 2 < N && c + 1 < N)
//		{
//			tmp = arr[r][c] + arr[r+1][c] + arr[r+1][c+1] + arr[r+2][c+1];
//			sum = Math.max(sum, tmp);
//		}
		//T
		if(r + 1 < N && c + 2 < N)
		{
			tmp = arr[r][c] + arr[r][c+1] + arr[r+1][c+1] + arr[r][c+2];
			sum = Math.max(sum, tmp);
		}
		if(r + 2 < N && c - 1 >= 0)
		{
			tmp = arr[r][c] + arr[r+1][c] + arr[r+1][c-1] + arr[r+2][c];
			sum = Math.max(sum, tmp);
		}
		if(r + 2 < N && c + 1 < N)
		{
			tmp = arr[r][c] + arr[r+1][c] + arr[r+1][c+1] + arr[r+2][c];
			sum = Math.max(sum, tmp);
		}
		if(r + 1 < N && c - 1 >= 0 && c + 1 < N)
		{
			tmp = arr[r][c] + arr[r+1][c] + arr[r+1][c-1] + arr[r+1][c+1];
			sum = Math.max(sum, tmp);
		}
		//¤±
		if(r + 1 < N && c + 1 < N)
		{
			tmp = arr[r][c] + arr[r][c+1] + arr[r+1][c] + arr[r+1][c+1];
			sum = Math.max(sum, tmp);
		}
		return sum;
	}
}