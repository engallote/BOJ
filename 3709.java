import java.util.*;
 
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        int[] dx = {1, 0, -1, 0}, dy = {0, -1, 0, 1};
        for(int test_case = 1; test_case <= tc; test_case++)
        {
        	int N = sc.nextInt();
            int r = sc.nextInt();
            int[][] arr = new int[N+2][N+2];
            
            for(int i = 0; i < r; i++)
            {
            	int x = sc.nextInt();
            	int y = sc.nextInt();
            	arr[x][y] = 1;//거울
            }
            
            int x = sc.nextInt();
            int y = sc.nextInt();
            int d = 0;
            int resX = 0, resY = 0;
            if(x == 0)//아래로 쏘기
            	d = 0;
            else if(x == N + 1) d = 2;
            else if(y == 0) d = 3;
            else d = 1;
            while(true)
        	{
        		if(x + dx[d] < 1 || x + dx[d] == N + 1 || y + dy[d] < 1 || y + dy[d] == N + 1)
        		{
        			resX = x + dx[d];
        			resY = y + dy[d];
        			break;
        		}
        		x += dx[d];
        		y += dy[d];
        		if(arr[x][y] == 1)
        			d = (d + 1) % 4;
        	}
            System.out.println(resX + " " + resY);
        }
    }
}