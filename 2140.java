import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] dx = {1, 0, -1, 0, 1, 1, -1, -1}, dy = {0, 1, 0, -1, 1, -1, 1, -1};
		char[][] map = new char[N][N];
		
		for(int i = 0; i < N; i++)
			map[i] = sc.next().toCharArray();
		
		for(int i = 1; i < N-1; i++)
		{
			for(int j = 1; j < N - 1; j++)
				if(map[i][j] == '#')
				{
					Vector<Pair> v = new Vector<>();
					boolean flag = false;
					for(int k = 0; k < 8; k++)
					{
						int nx = i + dx[k], ny = j + dy[k];
						if(map[nx][ny] == '0')
						{
							flag = true;
							break;
						}
						else if(map[nx][ny] >= '1')
							v.add(new Pair(nx, ny));
					}
					if(flag) map[i][j] = '.';
					else
					{
						for(int k = 0; k < v.size(); k++)
						{
							Pair p = v.get(k);
							int num = map[p.x][p.y] - '0';
							num -= 1;
							map[p.x][p.y] = (char) (num + '0');
						}
					}
				}
		}
		
		int res = 0;
		for(int i = 1; i < N-1; i++)
			for(int j = 1; j < N-1; j++)
				if(map[i][j] == '#') res++;
		
		System.out.println(res);
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