import java.util.*;

public class Main {
	static int N, flag = 0;
	static String ans = "ongoing";
	static char[][] map;
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new char[N][N];
		
		
		for(int i = 0; i < N; i++)
			map[i] = sc.next().toCharArray();
		
		for(int i = 0; i < N; i++)
			for(int j = 0; j < N; j++)
				if(flag != 1)
					solve(i, j);
		
		System.out.println(ans);
	}
	private static void solve(int x, int y) {
		
		if(x + 2 < N)
		{
			if(map[x][y] != '.' && map[x][y] == map[x+1][y] && map[x+1][y]== map[x+2][y])
			{
				ans = Character.toString(map[x][y]);
				flag = 1;
				return;
			}
		}
		if(y + 2 < N)
		{
			if(map[x][y] != '.' && map[x][y] == map[x][y+1] && map[x][y+1]== map[x][y+2])
			{
				ans = Character.toString(map[x][y]);
				flag = 1;
				return;
			}
		}
		if(x + 2 < N && y + 2 < N)
		{
			if(map[x][y] != '.' && map[x][y] == map[x+1][y+1] && map[x+1][y+1]== map[x+2][y+2])
			{
				ans = Character.toString(map[x][y]);
				flag = 1;
				return;
			}
		}
		if(x + 2 < N && y - 2 >= 0)
		{
			if(map[x][y] != '.' && map[x][y] == map[x+1][y-1] && map[x+1][y-1]== map[x+2][y-2])
			{
				ans = Character.toString(map[x][y]);
				flag = 1;
				return;
			}
		}
	}
}