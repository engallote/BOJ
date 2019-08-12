import java.util.*;

public class Main {
	static char[][][] arr;
	static int[] dh = {1, -1, 0, 0, 0, 0}, dx = {0, 0, 1, 0, -1, 0}, dy = {0, 0, 0, 1, 0, -1};
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true)
        {
        	int H = sc.nextInt();
        	int N = sc.nextInt();
        	int M = sc.nextInt();
        	if(H == 0 && N == 0 && M == 0) break;
        	int res = -1;
        	boolean[][][] chk = new boolean[H][N][M];
        	arr = new char[H][N][M];
        	PriorityQueue<Pair> pq = new PriorityQueue<>();
        	for(int i = 0; i < H; i++)
        		for(int j = 0; j < N; j++)
        		{
        			arr[i][j] = sc.next().toCharArray();
        			for(int k = 0; k < M; k++)
        			{
//        				System.out.print(arr[i][j][k]);
        				if(arr[i][j][k] == 'S')
        				{
        					pq.add(new Pair(i, j, k, 0));
        					chk[i][j][k] = true;
        				}
        			}
//        			System.out.println();
        		}
        				
        	while(!pq.isEmpty())
        	{
        		Pair p = pq.poll();
        		if(arr[p.h][p.x][p.y] == 'E')
        		{
        			res = p.cnt;
        			break;
        		}
        		for(int i = 0; i < 6; i++)
        		{
        			int nh = p.h + dh[i], nx = p.x + dx[i], ny = p.y + dy[i];
        			if(nh < 0 || nx < 0 || ny < 0 || nh >= H || nx >= N || ny >= M || arr[nh][nx][ny] == '#' || chk[nh][nx][ny])
        				continue;
        			chk[nh][nx][ny] = true;
        			pq.add(new Pair(nh, nx, ny, p.cnt + 1));
        		}
        	}
        	if(res == -1)
        		System.out.println("Trapped!");
        	else
        		System.out.println("Escaped in " + res + " minute(s).");
        }
	}
}
class Pair implements Comparable<Pair>{
	int h, x, y, cnt;
	Pair(int h, int x, int y, int cnt)
	{
		this.h = h;
		this.x = x;
		this.y = y;
		this.cnt = cnt;
	}
	@Override
	public int compareTo(Pair o) {
		return o.cnt > this.cnt ? -1 : 1;
	}
}