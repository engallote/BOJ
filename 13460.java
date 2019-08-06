import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
		char[][] arr = new char[N][M];
		boolean[][][][] chk = new boolean[N][M][N][M];
		Pair blue = new Pair(), red = new Pair();
		for(int i = 0; i < N; i++)
		{
			arr[i] = sc.next().toCharArray();
			for(int j = 0; j < M; j++)
			{
				if(arr[i][j] == 'B')
					blue = new Pair(i, j);
				else if(arr[i][j] == 'R')
					red = new Pair(i, j);
			}
		}
		
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		pq.add(new Pair(red.x, red.y, blue.x, blue.y, 0));
		boolean rh = false;
		int res = 0;
		while(!pq.isEmpty())
		{
			Pair p = pq.poll();
			chk[p.rx][p.ry][p.bx][p.by] = true;
			boolean r = false, b = false;
			for(int i = 0; i < 4; i++)
			{
				//���� ���� �����̱�
				int rx = p.rx + dx[i], ry = p.ry + dy[i];
				r = false;
				b = false;
				while(rx >= 0 && ry >= 0 && rx < N && ry < M)
				{
					if(arr[rx][ry] == '#')
					{
						rx -= dx[i];
						ry -= dy[i];
						break;
					}
					else if(arr[rx][ry] == 'O')
					{
						r = true;
						break;
					}
					rx += dx[i];
					ry += dy[i];
				}
				red.x = rx;
				red.y = ry;
				//��� ���� �����̱�
				int bx = p.bx + dx[i], by = p.by + dy[i];
				while(bx >= 0 && by >= 0 && bx < N && by < M)
				{
					if(arr[bx][by] == '#')
					{
						bx -= dx[i];
						by -= dy[i];
						break;
					}
					else if(arr[bx][by] == 'O')
					{
						b = true;
						break;
					}
					bx += dx[i];
					by += dy[i];
				}
				blue.x = bx;
				blue.y = by;
				
				if(b) continue;
				if(red.x == blue.x && red.y == blue.y)//������ ��ħ
				{
					if(i == 0)//�Ʒ��� �������� ���
					{
						if(p.rx > p.bx)//��� ������ ���� �־���
						{
							blue.x -= dx[i];
							blue.y -= dy[i];
						}
						else
						{
							red.x -= dx[i];
							red.y -= dy[i];
						}
					}
					else if(i == 1)//���������� �������� ���
					{
						if(p.ry > p.by)//���� ������ ���ʿ� �־���
						{
							blue.x -= dx[i];
							blue.y -= dy[i];
						}
						else
						{
							red.x -= dx[i];
							red.y -= dy[i];
						}
					}
					else if(i == 2)//���� �������� ���
					{
						if(p.rx < p.bx)//��� ������ �Ʒ��� �־���
						{
							blue.x -= dx[i];
							blue.y -= dy[i];
						}
						else
						{
							red.x -= dx[i];
							red.y -= dy[i];
						}
					}
					else//�������� �������� ���
					{
						if(p.ry < p.by)//���� ������ ���ʿ� �־���
						{
							blue.x -= dx[i];
							blue.y -= dy[i];
						}
						else
						{
							red.x -= dx[i];
							red.y -= dy[i];
						}
					}
				}
				
				if(!chk[red.x][red.y][blue.x][blue.y] && !b && p.cnt + 1 <= 10)
				{
					if(r)
					{
						res = p.cnt + 1;
						rh = true;
						break;
					}
					else
						pq.add(new Pair(red.x, red.y, blue.x, blue.y, p.cnt + 1));
				}			
				if(rh) break;
			}
			if(rh) break;
		}
		System.out.println(rh ? res : -1);
	}
}
class Pair implements Comparable<Pair>{
	int x, y, cnt;
	int rx, ry, bx, by;
	Pair(){}
	Pair(int x, int y){
		this.x = x;
		this.y = y;
	}
	Pair(int x, int y, int cnt){
		this.x = x;
		this.y = y;
		this.cnt = cnt;
	}
	Pair(int rx, int ry, int bx, int by, int cnt)
	{
		this.rx = rx;
		this.ry = ry;
		this.bx = bx;
		this.by = by;
		this.cnt = cnt;
	}
	@Override
	public int compareTo(Pair o) {
		return o.cnt > this.cnt ? -1 : 1;
	}
}