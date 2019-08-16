import java.util.*;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int num = sc.nextInt();
        int x = 0, y = 0;
        int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
        char[][] arr = new char[N][M];
        boolean[][][] chk = new boolean[N][M][num + 1];
        for(int i = 0; i < N; i++)
        {
        	arr[i] = sc.next().toCharArray();
        	for(int j = 0; j < M; j++)
        		if(arr[i][j] == 'S')
        		{
        			x = i;
        			y = j;
        			arr[i][j] = '.';
        		}
        }
        
        chk[x][y][0] = true;
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(x, y, 0, 0));
        
        while(!pq.isEmpty())
        {
        	Pair p = pq.poll();
//        	System.out.println(p.x + " " + p.y + " " + p.num);
        	if(p.num == num)
        	{
        		System.out.println(p.cnt);
        		break;
        	}
        	for(int i = 0; i < 4; i++)
        	{
        		int nx = p.x + dx[i], ny = p.y + dy[i];
        		if(nx < 0 || ny < 0 || nx >= N || ny >= M || arr[nx][ny] == 'X' || chk[nx][ny][p.num]) 
        			continue;
        		chk[nx][ny][p.num] = true;
        		if(arr[nx][ny] == '.' || arr[nx][ny] - '0' != p.num + 1)
        			pq.add(new Pair(nx, ny, p.num, p.cnt + 1));
        		else if(arr[nx][ny] - '0' == p.num + 1)
        			pq.add(new Pair(nx, ny, p.num + 1, p.cnt + 1));
        	}
        }
	}
}
class Pair implements Comparable<Pair>{
	int x, y, num, cnt;
	Pair(int x, int y, int num, int cnt)
	{
		this.x = x;
		this.y = y;
		this.num = num;
		this.cnt = cnt;
	}
	@Override
	public int compareTo(Pair o) {
		if(o.cnt > this.cnt) return -1;
		else if(o.cnt == this.cnt)
		{
			if(o.num > this.num) return 1;
			else if(o.num == this.num) return 0;
			else return -1;
		}
		else return 1;
	}
}