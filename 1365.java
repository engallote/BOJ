import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
    	long[] arr = new long[N+1], dp = new long[N+1];
    	int idx = 1;
    	for(int i = 1; i <= N; i++)
    		arr[i] = sc.nextLong();
    	
    	dp[1] = arr[1];
    	
    	for(int i = 2; i <= N; i++)
    	{
    		if(arr[i] > dp[idx]) dp[++idx] = arr[i];
    		else
    		{
    			int left = 1, right = idx, mid;
    			while(left < right)
    			{
    				mid = (left + right) / 2;
    				if(dp[mid] >= arr[i]) right = mid;
    				else left = mid + 1;
    			}
    			dp[right] = arr[i];
    		}
    	}
    	
    	System.out.println(N-idx);
    }
}