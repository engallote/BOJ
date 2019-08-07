import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int bx = sc.nextInt();
		int by = sc.nextInt();
		int dx = sc.nextInt();
		int dy = sc.nextInt();
		int jx = sc.nextInt();
		int jy = sc.nextInt();
		boolean[][] chk = new boolean[1001][1001];
		int[] rx = {1, 0, -1 , 0, 1, 1, -1, -1}, ry = {0, 1, 0, -1, 1, -1, 1, -1};
		Queue<Pair> bessie = new LinkedList<>(), daisy = new LinkedList<>();
		bessie.add(new Pair(bx, by, 0));
		daisy.add(new Pair(dx, dy, 0));
		chk[bx][by] = true;
		String who = "";
		int bc = Integer.MAX_VALUE, dc = Integer.MAX_VALUE;
		while(!bessie.isEmpty())
		{
			int size = bessie.size();
			
			for(int t = 0; t < size; t++)
			{
				Pair p = bessie.poll();
//				System.out.println(p.x + " " + p.y + " " + p.cnt);
				if(p.x == jx && p.y == jy)
				{
					bc = p.cnt;
					bessie.clear();
					break;
				}
				for(int j = 0; j < 8; j++)
				{
					int nx = p.x + rx[j], ny = p.y + ry[j];
					if(nx < 1 || ny < 1 || nx > 1000 || ny > 1000 || chk[nx][ny])
						continue;
					chk[nx][ny] = true;
					bessie.add(new Pair(nx, ny, p.cnt + 1));
				}
			}
		}
		
		for(int i = 0; i <= 1000; i++)
			Arrays.fill(chk[i], false);
		chk[dx][dy] = true;
		while(!daisy.isEmpty())
		{
			int size = daisy.size();
			
			for(int t = 0; t < size; t++)
			{
				Pair p = daisy.poll();
//				System.out.println("??");
				if(p.x == jx && p.y == jy)
				{
					dc = p.cnt;
					daisy.clear();
					break;
				}
				for(int j = 0; j < 4; j++)
				{
					int nx = p.x + rx[j], ny = p.y + ry[j];
					if(nx < 1 || ny < 1 || nx > 1000 || ny > 1000 || chk[nx][ny])
						continue;
					chk[nx][ny] = true;
					daisy.add(new Pair(nx, ny, p.cnt + 1));
				}
			}
		}
//		System.out.println(bc + " " + dc);
		if(dc > bc) who = "bessie";
		else if(dc < bc) who = "daisy";
		else who = "tie";
		System.out.println(who);
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