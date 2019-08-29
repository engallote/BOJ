import java.util.*;

public class Main {
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String s = sc.next();
		char[] c = s.toCharArray();
		boolean[][] map = new boolean[1001][1001];
		int sx = 500, sy = 500, minX = 500, minY = 500, maxX = 500, maxY = 500;
		int dir = 3;//4 : ¼­, 1 : ºÏ, 2: µ¿, 3 : ³²
		map[sx][sy] = true;
		
		for(int i = 0; i < N; i++)
		{
			if(c[i] == 'R')
			{
				dir = (dir + 1) % 4;
				if(dir == 0)
					dir = 4;
			}
			else if(c[i] == 'L')
			{
				dir = (dir - 1) % 4;
				if(dir == 0)
					dir = 4;
			}
			else if(c[i] == 'F')
			{
				if(dir == 1)//ºÏ
				{
					sx -= 1;
					if(minX > sx)
						minX = sx;
					map[sx][sy] = true;
				}
				else if(dir == 2)//µ¿
				{
					sy += 1;
					if(maxY < sy)
						maxY = sy;
					map[sx][sy] = true;
				}
				else if(dir == 3)//³²
				{
					sx += 1;
					if(maxX < sx)
						maxX = sx;
					map[sx][sy] = true;
				}
				else//¼­
				{
					sy -= 1;
					if(minY > sy)
						minY = sy;
					map[sx][sy] = true;
				}
			}
		}
		
		for(int i = minX; i <= maxX; i++)
		{
			for(int j = minY; j <= maxY; j++)
			{
				if(map[i][j])
					System.out.print(".");
				else
					System.out.print("#");
			}
			System.out.println();
		}
	}
}