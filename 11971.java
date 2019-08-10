import java.util.*;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] arr = new int[101];
        int start = 0, res = 0;
        for(int i = 0; i < N; i++)
        {
        	int num = sc.nextInt();
        	int k = sc.nextInt();
        	
        	for(int j = start + 1; j <= Math.min(start + num, 100); j++)
        		arr[j] = k;
        	start += num;
        }
         
        start = 0;
        for(int i = 0; i < M; i++)
        {
        	int d = sc.nextInt();
        	int k = sc.nextInt();
        	
        	for(int j = start + 1; j <= Math.min(start + d, 100); j++)
        		res = Math.max(res, k - arr[j]);
        	
        	start += d;
        }
        System.out.println(res);
	}
}