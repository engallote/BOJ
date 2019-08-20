import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] dx = {-2, -2, -1, -1, 1, 1, 2, 2}, dy = {-1, 1, -2, 2, -2, 2, -1, 1};
		int[][] arr;
		boolean[][] chk;
		while(sc.hasNext())
		{
			String s = sc.next();
			String e = sc.next();
			char[] st = s.toCharArray();
			char[] ed = e.toCharArray();
			arr = new int[8][8];
			chk = new boolean[8][8];
			
			int sx = (st[0] - 'a'), sy = (st[1] - '0') - 1, ex = (ed[0] - 'a'), ey = (ed[1] - '0') - 1;
//			System.out.println(sx + " " + sy);
			Queue<Pair> q = new LinkedList<>();
			q.add(new Pair(sx, sy, 0));
			chk[sx][sy] = true;
			int res = 0;
			while(!q.isEmpty())
			{
				Pair p = q.poll();
				if(p.x == ex && p.y == ey)
				{
					res = p.cnt;
					break;
				}
				
				for(int i = 0; i < 8; i++)
				{
					int nx = p.x + dx[i], ny = p.y + dy[i];
					if(nx < 0 || ny < 0 || nx >= 8 || ny >= 8 || chk[nx][ny]) continue;
					chk[nx][ny] = true;
					q.add(new Pair(nx, ny, p.cnt + 1));
				}
			}
			
			System.out.printf("To get from %s to %s takes %d knight moves.\n", s, e, res);
		}
	}
}
class Pair{
	int x, y, cnt;
	Pair(int x, int y, int cnt)
	{
		this.x = x;
		this.y = y;
		this.cnt = cnt;
	}
}