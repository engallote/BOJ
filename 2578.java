import java.util.*;

public class Main {
	static boolean end = false;
	static boolean[][] chk = new boolean[5][5];
	static Pair[] arr = new Pair[26];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);			
		
		for(int i = 0; i < 5; i++)
			for(int j = 0; j < 5; j++)
			{
				int n = sc.nextInt();
				arr[n] = new Pair(i, j);
			}
		
		int cnt = 0, ans = 0;
		for(int i = 0; i < 5; i++)
		{
			for(int j = 0; j < 5; j++)
			{
				int n = sc.nextInt();
				if(end) continue;
				cnt++;
				int x = arr[n].x, y = arr[n].y;
				chk[x][y] = true;
				bingo();
				if(end)
					ans = cnt;
			}
		}
		System.out.println(ans);
	}
	private static void bingo() {
		int count = 0;
		for(int i = 0; i < 5; i++)
		{
			boolean flag = true;
			for(int j = 0; j < 5; j++)
			{
				if(!chk[i][j])
				{
					flag = false;
					break;
				}
			}
			if(flag)
				count++;		
		}
		
		for(int i = 0; i < 5; i++)
		{
			boolean flag = true;
			for(int j = 0; j < 5; j++)
			{
				if(!chk[j][i])
				{
					flag = false;
					break;
				}
			}
			if(flag)
				count++;
		}
		
		int x = 0, y = 0;
		while(true)
		{
			if(!chk[x][y]) break;
			x++;
			y++;
			if(x == 5 && y == 5)
			{
				count++;
				break;
			}
		}
		
		x = 0;
		y = 4;
		while(true)
		{
			if(!chk[x][y]) break;
			x++;
			y--;
			if(x == 5 && y == -1)
			{
				count++;
				break;
			}
		}
		
		if(count >= 3) end = true;
	}
}
class Pair{
	int x, y;
	Pair(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
}