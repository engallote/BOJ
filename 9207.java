import java.util.*;

public class Main {
	static int minC, minN, num, cnt;
	static char[][] arr;
	static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        
        for(int t = 0; t < tc; t++)
        {
        	arr = new char[5][9];
        	minC = minN = Integer.MAX_VALUE;
        	num = 0;
        	cnt = 0;
        	for(int i = 0; i < 5; i++)
        	{
        		arr[i] = sc.next().toCharArray();
        		for(int j = 0; j < 9; j++)
        			if(arr[i][j] == 'o')
        				num++;
        	}
        	
        	dfs();
        	System.out.println(minN + " " + minC);
        }
    }
	private static void dfs() {
		if(minN > num)
		{
			minN = num;
			minC = cnt;
		}
		else if(minN == num && minC > cnt)
			minC = cnt;
		
		for(int i = 0; i < 5; i++)
		{
			for(int j = 0; j < 9; j++)
			{
				if(arr[i][j] != 'o') continue;
				for(int k = 0; k < 4; k++)
				{
					int nx = i + dx[k], ny = j + dy[k];
					if(nx < 0 || ny < 0 || nx >= 5 || ny >= 9 || arr[nx][ny] != 'o') continue;
					if(nx + dx[k] < 0 || nx + dx[k] >= 5 || ny + dy[k] < 0 || ny + dy[k] >= 9) continue;
					if(arr[nx + dx[k]][ny + dy[k]] != '.') continue;
					num--;
					cnt++;
					arr[i][j] = arr[nx][ny] = '.';
					arr[nx + dx[k]][ny + dy[k]] = 'o';
					dfs();
					num++;
					cnt--;
					arr[nx + dx[k]][ny + dy[k]] = '.';
					arr[i][j] = arr[nx][ny] = 'o';
				}
			}
		}
	}
}