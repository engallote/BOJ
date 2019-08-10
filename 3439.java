import java.util.*;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
        int r = 0, y = 1, b = 2, g = 3;
        while(true)
        {
        	int N = sc.nextInt();
        	int M = sc.nextInt();
        	if(N == 0 && M == 0) break;
        	boolean[][][] chk = new boolean[N][M][1<<4];
        	PriorityQueue<Pair> pq = new PriorityQueue<>();
        	char[][] arr = new char[N][M];
        	boolean esc = false;
        	for(int i = 0; i < N; i++)
        	{
        		arr[i] = sc.next().toCharArray();
        		for(int j = 0; j < M; j++)
        		{
        			if(arr[i][j] == '*')
        			{
        				pq.add(new Pair(i, j, 0, 0));
        				chk[i][j][0] = true;
        			}
        			else if(arr[i][j] == 'X')
        				esc = true;
        		}
        	}
        	
        	if(!esc)
        	{
        		System.out.println("The poor student is trapped!");
        		continue;
        	}
        	int res = -1;
        	while(!pq.isEmpty())
        	{
        		Pair p = pq.poll();
        		
        		if(arr[p.x][p.y] == 'X')
        		{
        			res = p.cnt;
        			break;
        		}
        		
        		for(int i = 0; i < 4; i++)
        		{
        			int nx = p.x + dx[i], ny = p.y + dy[i];
        			if(nx < 0 || ny < 0 || nx >= N || ny >= M || chk[nx][ny][p.key] || arr[nx][ny] == '#')
        				continue;
        			if(arr[nx][ny] == 'r' || arr[nx][ny] == 'b' || arr[nx][ny] == 'y' || arr[nx][ny] == 'g')
        			{
        				chk[p.x][p.y][p.key] = true;
        				if(arr[nx][ny] == 'r')
        				{
        					if((p.key&(1<<r)) == 0)
        						pq.add(new Pair(nx, ny, p.key|(1<<r), p.cnt + 1));
        					else
        						pq.add(new Pair(nx, ny, p.key, p.cnt + 1));
        				}
        				else if(arr[nx][ny] == 'b')
        				{
        					if((p.key&(1<<b)) == 0)
        						pq.add(new Pair(nx, ny, p.key|(1<<b), p.cnt + 1));
        					else
        						pq.add(new Pair(nx, ny, p.key, p.cnt + 1));
        				}
        				else if(arr[nx][ny] == 'y')
        				{
        					if((p.key&(1<<y)) == 0)
        						pq.add(new Pair(nx, ny, p.key|(1<<y), p.cnt + 1));
        					else
        						pq.add(new Pair(nx, ny, p.key, p.cnt + 1));
        				}
        				else
        				{
        					if((p.key&(1<<g)) == 0)
        						pq.add(new Pair(nx, ny, p.key|(1<<g), p.cnt + 1));
        					else
        						pq.add(new Pair(nx, ny, p.key, p.cnt + 1));
        				}
        			}
        			else if(arr[nx][ny] == 'R' || arr[nx][ny] == 'B' || arr[nx][ny] == 'Y' || arr[nx][ny] == 'G')
        			{
        				if(arr[nx][ny] == 'R' && (p.key&(1<<r)) != 0)
        				{
        					chk[nx][ny][p.key] = true;
        					pq.add(new Pair(nx, ny, p.key, p.cnt + 1));
        				}
        				else if(arr[nx][ny] == 'Y' && (p.key&(1<<y)) != 0)
        				{
        					chk[nx][ny][p.key] = true;
        					pq.add(new Pair(nx, ny, p.key, p.cnt + 1));
        				}
        				else if(arr[nx][ny] == 'B' && (p.key&(1<<b)) != 0)
        				{
        					chk[nx][ny][p.key] = true;
        					pq.add(new Pair(nx, ny, p.key, p.cnt + 1));
        				}
        				else if(arr[nx][ny] == 'G' && (p.key&(1<<g)) != 0)
        				{
        					chk[nx][ny][p.key] = true;
        					pq.add(new Pair(nx, ny, p.key, p.cnt + 1));
        				}
        			}
        			else
        			{
        				chk[nx][ny][p.key] = true;
        				pq.add(new Pair(nx, ny, p.key, p.cnt + 1));
        			}
        		}
        	}
        	
        	if(res == -1)
        		System.out.println("The poor student is trapped!");
        	else
        		System.out.println("Escape possible in " + res + " steps.");
        }
	}
}
class Pair implements Comparable<Pair>{
	int x, y, key, cnt;
	Pair(int x, int y, int key, int cnt)
	{
		this.x = x;
		this.y = y;
		this.key = key;
		this.cnt = cnt;
	}
	@Override
	public int compareTo(Pair o) {
		return o.cnt > this.cnt ? -1 : 1;
	}
}