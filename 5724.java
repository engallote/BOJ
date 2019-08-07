import java.util.*;
 
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true)
        {
        	int N = sc.nextInt();
        	if(N == 0) break;
        	int[][] arr = new int[N][N];
        	
        	for(int i = 0; i < N; i++)
        		for(int j = 0; j < N; j++)
        		{
        			if(i == 0 || j == 0) arr[i][j] = 1;
        			else
        				arr[i][j] = Math.min(arr[i-1][j], Math.min(arr[i][j-1], arr[i-1][j-1])) + 1;
        		}
        	
//        	for(int i = 0; i < N; i++)
//        	{
//        		for(int j = 0; j < N; j++)
//        			System.out.print(arr[i][j] + " ");
//        		System.out.println();
//        	}
        	
        	int res = N * N;
        	for(int k = 2; k <= N; k++)
        	{
        		for(int i = 0; i < N; i++)
        			for(int j = 0; j < N; j++)
        				if(arr[i][j] >= k) res++;
        	}
        	System.out.println(res);
        }
    }
}