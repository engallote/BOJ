import java.util.*;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        long[][] arr = new long[N+1][N+1];
        for(int i = 1; i <= N; i++)
        	for(int j = 1; j <= N; j++)
        		arr[i][j] = sc.nextLong();
        
        for(int k = 1; k <= N; k++)
        	for(int i = 1; i <= N; i++)
        		for(int j = 1; j <= N; j++)
        			if(arr[i][k] + arr[k][j] < arr[i][j])
        				arr[i][j] = arr[i][k] + arr[k][j];
        
        for(int t = 0; t < M; t++)
        {
        	int a = sc.nextInt();
        	int b = sc.nextInt();
        	long c = sc.nextLong();
        	
        	if(arr[a][b] <= c)
        		System.out.println("Enjoy other party");
        	else
        		System.out.println("Stay here");
        }
	}
}