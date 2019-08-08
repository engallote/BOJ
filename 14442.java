import java.util.*;
 
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int K = sc.nextInt();
        char[][] arr = new char[N][M];
        boolean[][][] chk = new boolean[N][M][K+1];
        int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
        for(int i = 0; i < N; i++)
        	arr[i] = sc.next().toCharArray();
        int res = -1;
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0, 0, K, 1));
        chk[0][0][0] = true;
        while(!pq.isEmpty())
        {
        	Pair p = pq.poll();
        	
        	if(p.x == N - 1  && p.y == M - 1)
        	{
        		res = p.cnt;
        		break;
        	}
        	for(int i = 0; i < 4; i++)
        	{
        		int nx = p.x + dx[i], ny = p.y + dy[i];
        		if(nx < 0 || ny < 0 || nx >= N || ny >= M || chk[nx][ny][p.k]) continue;
        		if(arr[nx][ny] == '0')
        		{
        			chk[nx][ny][p.k] = true;
        			pq.add(new Pair(nx, ny, p.k, p.cnt + 1));
        		}
        		else if(p.k > 0 && arr[nx][ny] == '1')
        		{
        			chk[nx][ny][p.k] = true;
        			pq.add(new Pair(nx, ny, p.k - 1, p.cnt + 1));
        		}
        	}
        }
        
        System.out.println(res);
    }
}
class Pair implements Comparable<Pair>{
	int x, y, k, cnt;
	Pair(int x, int y, int k, int cnt)
	{
		this.x = x;
		this.y = y;
		this.k = k;
		this.cnt = cnt;
	}
	@Override
	public int compareTo(Pair o) {
		return o.cnt > this.cnt ? -1 : 1;
	}
}