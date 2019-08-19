import java.util.*;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] arr = new int[101][101];
        int[] res = new int[N+1];
        for(int i = 1; i <= N; i++)
        {
        	int sx = sc.nextInt();
        	int sy = sc.nextInt();
        	int x = sc.nextInt();
        	int y = sc.nextInt();
        	
        	for(int a = sx; a < sx+x; a++)
        		for(int b = sy; b < sy+y; b++)
        			arr[a][b] = i;
        }
        
        for(int i = 1; i <= N; i++)
        {
        	for(int a = 0; a <= 100; a++)
        		for(int b = 0; b <= 100; b++)
        			if(arr[a][b] == i)
        				res[i]++;
        }
        
        for(int i = 1; i <= N; i++)
        	System.out.println(res[i]);
    }
}