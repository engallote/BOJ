import java.util.*;
 
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int K = sc.nextInt();
        int res = Integer.MAX_VALUE;
        char[][] arr = new char[N][M];
        boolean[][][] chk = new boolean[N][M][K+1];
        int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
        
        for(int i = 0; i < N; i++)
        	arr[i] = sc.next().toCharArray();
        
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0, 0, 0, 1));
        chk[0][0][0] = true;
        
        int day = 0;
        while(!q.isEmpty())
        {
        	int size = q.size();
        	
        	for(int k = 0; k < size; k++)
        	{
        		Pair p = q.poll();
//            	System.out.println(day + " : " + p.x + " " + p.y + " " + p.cnt);
            	if(p.x == N - 1 && p.y == M - 1)
            	{
            		res = p.cnt;
            		continue;
            	}
            	
            	for(int i = 0; i < 4; i++)
            	{
            		int nx = p.x + dx[i], ny = p.y + dy[i];
            		if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
            		if(arr[nx][ny] == '0' && !chk[nx][ny][p.k])
            		{
            			chk[nx][ny][p.k] = true;
            			q.add(new Pair(nx, ny, p.k, p.cnt + 1));
            		}
            		else if(p.k < K && arr[nx][ny] == '1')
            		{
//            			System.out.println("day : " +day + " " + p.cnt);
            			if(day == 1)//밤이면 제자리에서 머물기
            			{
            				q.add(new Pair(p.x, p.y, p.k, p.cnt + 1));
            			}
            			else//낮
            			{
            				if(!chk[nx][ny][p.k + 1])
            				{
            					chk[nx][ny][p.k + 1] = true;
                				q.add(new Pair(nx, ny, p.k + 1, p.cnt + 1));
            				}
            			}
            		}
            	}
        	}
        	day = Math.abs(day - 1);
        	if(res != Integer.MAX_VALUE) break;
        }
        System.out.println(res == Integer.MAX_VALUE ? -1 : res);
    }
}
class Pair{
	int x, y, cnt, k;
	Pair(int x, int y, int k, int cnt)
	{
		this.x = x;
		this.y = y;
		this.k = k;
		this.cnt = cnt;
	}
}