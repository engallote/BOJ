import java.util.*;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true)
        {
        	int N = sc.nextInt();
        	if(N == 0) break;
        	int res = Integer.MIN_VALUE;
        	int min = Integer.MAX_VALUE;
        	int[] arr = new int[N+1], sum = new int[N+1];
        	for(int i = 1; i <= N; i++)
        	{
        		arr[i] = sc.nextInt();
        		if(res < arr[i]) res = arr[i];
        		sum[i] = arr[i] + sum[i-1];
        		if(min > sum[i-1]) min = sum[i-1];
        		res = Math.max(res, sum[i] - min);
        	}
        	
        	System.out.println(res);
        }
    }
}