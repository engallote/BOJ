import java.util.*;
 
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int res = 0;
        int[][] arr = new int[N][N];
        int[] dx = {1, 0, -1, 0, 1, 1, -1, -1, 2, -2, 1, -1, 2, -2, 1, -1}, dy = {0, 1, 0, -1, 1, -1, 1, -1, 1, 1, 2, 2, -1, -1, -2, -2};
        int[][] bishop = new int[N][N], rook = new int[N][N], knight = new int[N][N];
        Queue<Pair> q = new LinkedList<>();
        int ex = 0, ey = 0;
        for(int i = 0; i < N; i++)
        {
        	Arrays.fill(bishop[i], Integer.MAX_VALUE);
        	Arrays.fill(rook[i], Integer.MAX_VALUE);
        	Arrays.fill(knight[i], Integer.MAX_VALUE);
        	for(int j = 0; j < N; j++)
        	{
        		arr[i][j] = sc.nextInt();
        		if(arr[i][j] == 1)
        		{
        			q.add(new Pair(1, i, j));
        			q.add(new Pair(2, i, j));
        			q.add(new Pair(3, i, j));
        			bishop[i][j] = rook[i][j] = knight[i][j] = 0;
        		}
        		else if(arr[i][j] == N * N)
        		{
        			ex = i;
        			ey = j;
        		}
        	}
        }
        Queue<Pair> tmp = new LinkedList<>();
        int num = 2;
        while(!q.isEmpty())
        {
        	int size = q.size();
        	
        	for(int k = 0; k < size; k++)
        	{
        		Pair p = q.poll();
        		if(arr[p.x][p.y] == num)//목표 수에 도달
        		{
        			int cnt = 0;
        			if(p.h == 1) cnt = rook[p.x][p.y];
        			else if(p.h == 2) cnt = bishop[p.x][p.y];
        			else cnt = knight[p.x][p.y];
        			tmp.add(new Pair(p.h, p.x, p.y, cnt));
        			continue;
        		}
            	if(p.h == 1)//rook
            	{
            		for(int i = 0; i < 4; i++)
                	{
                		int nx = p.x + dx[i], ny = p.y + dy[i];
                		while(nx >= 0 && ny >= 0 && nx < N && ny < N)
                		{
                			if(rook[nx][ny] > rook[p.x][p.y] + 1)
            				{
            					rook[nx][ny] = rook[p.x][p.y] + 1;
            					q.add(new Pair(p.h, nx, ny));
            				}
                			nx += dx[i];
                			ny += dy[i];
                		}
                	}
            		
            		//제자리에서 말 바꾸기
            		if(bishop[p.x][p.y] > rook[p.x][p.y] + 1)
            		{
            			bishop[p.x][p.y] = rook[p.x][p.y] + 1;
            			q.add(new Pair(2, p.x, p.y));
            		}
            		if(knight[p.x][p.y] > rook[p.x][p.y] + 1)
            		{
            			knight[p.x][p.y] = rook[p.x][p.y] + 1;
            			q.add(new Pair(3, p.x, p.y));
            		}
            	}
            	else if(p.h == 2)//bishop
            	{
            		for(int i = 4; i < 8; i++)//비숍 체크
            		{
            			int nx = p.x + dx[i], ny = p.y + dy[i];
                		while(nx >= 0 && ny >= 0 && nx < N && ny < N)
                		{
                			if(bishop[nx][ny] > bishop[p.x][p.y] + 1)
            				{
            					bishop[nx][ny] = bishop[p.x][p.y] + 1;
            					q.add(new Pair(2, nx, ny));
            				}
                			nx += dx[i];
                			ny += dy[i];
                		}
            		}
            		
            		//제자리에서 말 바꾸기
            		if(knight[p.x][p.y] > bishop[p.x][p.y] + 1)
            		{
            			knight[p.x][p.y] = bishop[p.x][p.y] + 1;
            			q.add(new Pair(3, p.x, p.y));
            		}
            		if(rook[p.x][p.y] > bishop[p.x][p.y] + 1)
            		{
            			rook[p.x][p.y] = bishop[p.x][p.y] + 1;
            			q.add(new Pair(1, p.x, p.y));
            		}
            	}
            	else//knight
            	{
            		for(int i = 8; i < 16; i++)//나이트 체크
            		{
            			int nx = p.x + dx[i], ny = p.y + dy[i];
            			if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
            			if(knight[nx][ny] > knight[p.x][p.y] + 1)
        				{
        					knight[nx][ny] = knight[p.x][p.y] + 1;
        					q.add(new Pair(p.h, nx, ny));
        				}
            		}
            		
            		//제자리에서 말 바꾸기
            		if(bishop[p.x][p.y] >knight[p.x][p.y] + 1)
            		{
            			bishop[p.x][p.y] = knight[p.x][p.y] + 1;
            			q.add(new Pair(2, p.x, p.y));
            		}
            		if(rook[p.x][p.y] > knight[p.x][p.y] + 1)
            		{
            			rook[p.x][p.y] = knight[p.x][p.y] + 1;
            			q.add(new Pair(1, p.x, p.y));
            		}
            	}
        	}//for size
        	
        	if(!tmp.isEmpty())//목표 수에 도착
        	{
        		q.clear();
        		for(int i = 0; i < N; i++)
        		{
        			Arrays.fill(bishop[i], Integer.MAX_VALUE);
                	Arrays.fill(rook[i], Integer.MAX_VALUE);
                	Arrays.fill(knight[i], Integer.MAX_VALUE);
        		}
        		
        		while(!tmp.isEmpty())
        		{
        			Pair p = tmp.poll();
        			q.add(new Pair(p.h, p.x, p.y));
        			if(p.h == 1) rook[p.x][p.y] = p.cnt;
        			else if(p.h == 2) bishop[p.x][p.y] = p.cnt;
        			else knight[p.x][p.y] = p.cnt;
        		}
        		num++;
        		if(num > N * N) break;
        	}
        }
        
        res = Math.min(rook[ex][ey], Math.min(bishop[ex][ey], knight[ex][ey]));
        
        System.out.println(res);
    }
}
class Pair{
	int x, y, cnt, h;
	Pair(int h, int x, int y)
	{
		this.h = h;
		this.x = x;
		this.y = y;
	}
	Pair(int h, int x, int y, int cnt)
	{
		this.h = h;
		this.x = x;
		this.y = y;
		this.cnt = cnt;
	}
}