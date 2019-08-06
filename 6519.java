import java.util.*;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
        boolean[][][] arr = new boolean[7][7][4];
        char[][] dir = new char[7][7];
        int[][] chk = new int[7][7];
        Pair[][] map = new Pair[7][7];
        int left = 3, right = 1, up = 2, down = 0;//못 간다는 표시
        while(true)
        {
        	int sy = sc.nextInt();
        	int sx = sc.nextInt();
        	if(sx == 0 && sy == 0) break;
        	int ey = sc.nextInt();
        	int ex = sc.nextInt();

        	for(int i = 0; i < 7; i++)
        	{
        		Arrays.fill(dir[i], '.');
        		Arrays.fill(chk[i], Integer.MAX_VALUE);
        		Arrays.fill(map[i], new Pair(-1, -1));
        		for(int j = 0; j < 7; j++)
        			Arrays.fill(arr[i][j], false);
        	}
        	
        	for(int i = 0; i < 3; i++)
        	{
        		int y1 = sc.nextInt();
        		int x1 = sc.nextInt();
        		int y2 = sc.nextInt();
        		int x2 = sc.nextInt();
        		
        		if(y1 == y2)//세로로 막힌 벽
        		{
        			for(int j = Math.min(x1, x2) + 1; j <= Math.max(x1, x2); j++)
        			{
        				if(y1 + 1 <= 6)
        					arr[j][y1+1][left] = true;
        				arr[j][y1][right] = true;
        			}
        		}
        		else//가로로 막힌 벽
        		{
        			for(int j = Math.min(y1, y2) + 1; j <= Math.max(y1, y2); j++)
        			{
        				arr[x1][j][down] = true;
        				if(x1 + 1 <= 6)
        					arr[x1 + 1][j][up] = true;
        			}
        		}
        	}
        	
        	PriorityQueue<Pair> pq = new PriorityQueue<>();
        	pq.add(new Pair(sx, sy, 0));
        	chk[sx][sy] = 0;
        	
        	while(!pq.isEmpty())
        	{
        		Pair p = pq.poll();
        		
        		if(p.x == ex && p.y == ey)
        		{
        			StringBuilder str = new StringBuilder();
        			int x = p.x, y = p.y;
        			while(dir[x][y] != '.')
        			{
        				str.append(dir[x][y]);
        				int xx = map[x][y].x;
        				int yy = map[x][y].y;
        				x = xx;
        				y = yy;
        			}
        			str.reverse();
        			System.out.println(str.toString());
        			break;
        		}
        		
        		for(int i = 0; i < 4; i++)
        		{
        			int nx = p.x + dx[i], ny = p.y + dy[i];
        			if(nx <= 0 || ny <= 0 || nx > 6 || ny > 6 || arr[p.x][p.y][i] || chk[nx][ny] < p.cnt + 1)
        				continue;
        			
        			chk[nx][ny] = p.cnt + 1;
        			map[nx][ny] = new Pair(p.x, p.y);
        			if(i == left) dir[nx][ny] = 'W';
        			else if(i == right) dir[nx][ny] = 'E';
        			else if(i == down) dir[nx][ny] = 'S';
        			else dir[nx][ny] = 'N';
        			pq.add(new Pair(nx, ny, p.cnt + 1));
        		}
        	}
        }
	}
}
class Pair implements Comparable<Pair>{
	int x, y, cnt;
	Pair(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	Pair(int x, int y, int cnt)
	{
		this.x = x;
		this.y = y;
		this.cnt = cnt;
	}
	@Override
	public int compareTo(Pair o) {
		return o.cnt > this.cnt ? -1 : 1;
	}
}