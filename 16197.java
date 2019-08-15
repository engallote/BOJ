import java.util.*;

public class Main {
	static int N, M, res;
	static char[][] arr;
	static boolean[][][][] chk;
	static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new char[N][M];
		chk = new boolean[N][M][N][M];
		ArrayList<Pair> aly = new ArrayList<>();
		Queue<ArrayList<Pair>> q = new LinkedList<>();
		for(int i = 0; i < N; i++)
		{
			arr[i] = sc.next().toCharArray();
			for(int j = 0; j < M; j++)
				if(arr[i][j] == 'o') aly.add(new Pair(i, j, 0));
		}
		q.offer(aly);
		chk[aly.get(0).x][aly.get(0).y][aly.get(1).x][aly.get(1).y] = true;
		res = -1;
		boolean flag = false;
		while(!q.isEmpty())
		{
			ArrayList<Pair> cur = q.poll();
			Pair one = cur.get(0), two = cur.get(1);
			
			for(int i = 0; i < 4; i++)
			{
				int ox = one.x + dx[i], oy = one.y + dy[i], tx = two.x + dx[i], ty = two.y + dy[i];
				if((ox < 0 || oy < 0 || ox >= N || oy >= M) && (tx < 0 || ty < 0 || tx >= N || ty >= M))
					continue;
				if((ox < 0 || oy < 0 || ox >= N || oy >= M) || (tx < 0 || ty < 0 || tx >= N || ty >= M))
				{
					flag = true;
					if(one.cnt + 1 <= 10) res = one.cnt + 1;
					break;
				}
				
				if(arr[ox][oy] == '#')
				{
					ox -= dx[i];
					oy -= dy[i];
				}
				if(arr[tx][ty] == '#')
				{
					tx -= dx[i];
					ty -= dy[i];
				}
				if(chk[ox][oy][tx][ty]) continue;
				chk[ox][oy][tx][ty] = true;
				ArrayList<Pair> next = new ArrayList<>();
				next.add(new Pair(ox, oy, one.cnt + 1));
				next.add(new Pair(tx, ty, one.cnt + 1));
				q.offer(next);
			}
			if(flag) break;
		}
		System.out.println(res);
	}
}
class Pair{
	int x, y, cnt;
	Pair(int x, int y, int cnt){
		this.x = x;
		this.y = y;
		this.cnt = cnt;
	}
}