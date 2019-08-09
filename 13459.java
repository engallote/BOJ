import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
 
public class Main {
    public static char[][] maze;//������
    public static boolean[][][][] visited;
    public static int result = 100;
    public static Positions red, blue;//��������, �Ķ����� ��ġ
    public static int dx[] = {1,0,-1,0}, dy[] = {0,1,0,-1};//������, ����, ��, �Ʒ��� �����̵��� �ϴ� ����
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        maze = new char[n][m];
        visited = new boolean[n][m][n][m];
        red = new Positions();
        blue = new Positions();
        
        for(int i = 0; i < n; i++)
        {
        	String s = sc.next();
        	for(int j = 0; j < m; j++)
        	{
        		char c = s.charAt(j);
        		if(c == 'R')
        		{
        			red.x = i;
        			red.y = j;
        		}
        		if(c == 'B')
        		{
        			blue.x = i;
        			blue.y = j;
        		}
        		maze[i][j] = c;
        	}
        }
        
        game(red, blue);
        System.out.println(result <= 10 ? 1 : 0);
    }
    public static void game(Positions red, Positions blue)
    {
    	ArrayList<Positions> a = new ArrayList<Positions>();
    	a.add(red);
    	a.add(blue);
    	Queue<ArrayList<Positions>> q = new LinkedList<ArrayList<Positions>>();
    	q.add(a);
    	
    	while(!q.isEmpty())
    	{
    		ArrayList<Positions> aly = q.poll();
    		Positions R = aly.get(0);
    		Positions B = aly.get(1);
    		visited[R.x][R.y][B.x][B.y] = true;
    		
    		for(int i = 0; i < 4; i++)
    		{
    			boolean rh = false, bh = false;
    			int rx = R.x, ry = R.y, bx = B.x, by = B.y, cnt = R.cnt;
    			
    			while(maze[bx + dx[i]][by + dy[i]] != '#')
    			{
    				bx += dx[i];
    				by += dy[i];
    				if(maze[bx][by] == 'O')
    					bh = true;
    			}
    			
    			while(maze[rx + dx[i]][ry + dy[i]] != '#')
    			{
    				rx += dx[i];
    				ry += dy[i];
    				if(maze[rx][ry] == 'O')
    					rh = true;
    			}
    			
    			if(rx == bx && ry == by)
    			{
    				if(R.x > B.x || R.y > B.y)
    				{
    					if(i > 1)//���� ���� �������� �������� ��� R.x�� R.y�� �� ū ��� �Ķ��������� �ڿ� �־��ٴ� ��
    					{
    						rx -= dx[i];
    						ry -= dy[i];
    					}
    					else//�ݴ�� �Ķ������� �������� �ڿ� �־��ٴ� ��
    					{
    						bx -= dx[i];
    						by -= dy[i];
    					}
    				}
    				else
    				{
    					if(i > 1)
    					{
    						bx -= dx[i];
    						by -= dy[i];
    					}
    					else
    					{
    						rx -= dx[i];
    						ry -= dy[i];
    					}
    				}
    			}
    			if(!visited[rx][ry][bx][by] && !bh)
    			{
    				if(rh)
    				{
    					result = cnt + 1;//�̹��� ������ �͵� ��꿡 �־�� �ϱ� ������ +1
    					return;
    				}
    				else if(cnt + 1 <= 10)
    				{
    					cnt += 1;
    					ArrayList<Positions> next = new ArrayList<Positions>();
    					next.add(new Positions(rx, ry, R.cnt + 1));
    					next.add(new Positions(bx, by, R.cnt + 1));
    					q.add(next);
    				}
    			}
    		}
    	}
    }
}
class Positions{
	int x, y, cnt;
	Positions(){
	}
	Positions(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	Positions(int x, int y, int cnt)
	{
		this.x = x;
		this.y = y;
		this.cnt = cnt;
	}
}