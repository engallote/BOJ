import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		int N = sc.nextInt();
		char[][] arr = new char[N][M];
		int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
		boolean[][][] chk = new boolean[N][M][1<<7];
		char ch = '1';
		int res = 0, stuff = 0;
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		for(int i = 0; i < N; i++)
		{
			arr[i] = sc.next().toCharArray();
			for(int j = 0; j < M; j++)
			{
				if(arr[i][j] == 'S')
				{
					arr[i][j] = '.';
					chk[i][j][0] = true;
					pq.add(new Pair(i, j, 0, 0, 0));
				}
				else if(arr[i][j] == 'X')
				{
					arr[i][j] = ch;
					stuff++;
					ch++;
				}
			}
		}
		
		while(!pq.isEmpty())
		{
			Pair p = pq.poll();
			
//			System.out.println(p.x + ", " + p.y + " : " + p.cnt + " " + p.st );
			if(arr[p.x][p.y] == 'E' && p.st == stuff)
			{
				System.out.println(p.cnt);
				break;
			}
			
			for(int i = 0; i < 4; i++)
			{
				int nx = p.x + dx[i], ny = p.y + dy[i];
				if(nx < 0 || ny < 0 || nx >= N || ny >= M || arr[nx][ny] == '#')
					continue;
				if((arr[nx][ny] == '.' || arr[nx][ny] == 'E'))
				{
					if(chk[nx][ny][p.chk]) continue;
					chk[nx][ny][p.chk] = true;
					pq.add(new Pair(nx, ny, p.cnt + 1, p.st, p.chk));
				}
				else
				{
					int key = (arr[nx][ny] - '0');
					if((p.chk&(1<<key)) == 0)
					{
						chk[nx][ny][p.chk|(1<<key)] = true;
						pq.add(new Pair(nx, ny, p.cnt + 1, p.st + 1, p.chk|(1<<key)));
					}
					else if(!chk[nx][ny][p.chk])
					{
						chk[nx][ny][p.chk] = true;
						pq.add(new Pair(nx, ny, p.cnt + 1, p.st, p.chk));
					}
				}
			}
		}
	}
}
class Pair implements Comparable<Pair>{
	int x, y, cnt, st, chk;
	Pair(int x, int y, int cnt, int st, int chk){
		this.x = x;
		this.y = y;
		this.cnt = cnt;
		this.st = st;
		this.chk = chk;
	}
	@Override
	public int compareTo(Pair o) {
		return o.cnt > this.cnt ? -1 : 1;
	}
}