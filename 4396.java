import java.util.*;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        char[][] map = new char[N][N], map2 = new char[N][N];
        int[][] arr = new int[N][N];
        int[] dr = {1, 0, -1, 0, 1, 1, -1, -1}, dc = {0, 1, 0, -1, 1, -1, 1, -1};
        for(int i = 0; i < N; i++)
        	map[i] = sc.next().toCharArray();
        
        for(int i = 0; i < N; i++)
        {
        	for(int j = 0; j < N; j++)
        		if(map[i][j] == '*')
        		{
        			for(int k = 0; k < 8; k++)
        			{
        				int nr = i + dr[k], nc = j + dc[k];
        				if(nr < 0 || nc < 0 || nr >= N || nc >= N || map[nr][nc] != '.')
        					continue;
        				arr[nr][nc]++;
        			}
        		}
        }
        
        boolean flag = false;
        for(int i = 0; i < N; i++)
        {
        	map2[i] = sc.next().toCharArray();
        	if(!flag)
        	{
        		for(int j = 0; j < N; j++)
            		if(map2[i][j] == 'x' && map[i][j] == '*')
            		{
            			flag = true;
            			break;
            		}
        	}
        }
        
        for(int i = 0; i < N; i++)
        {
        	for(int j = 0; j < N; j++)
        	{
        		if(flag && map[i][j] == '*')
        			System.out.print(map[i][j]);
        		else if(map2[i][j] == 'x')
        			System.out.print(arr[i][j]);
        		else System.out.print(map2[i][j]);
        	}
        	System.out.println();
        }
    }
}