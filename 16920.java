import java.util.*;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int P = sc.nextInt();
        int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
        Queue<Pair>[] q = new LinkedList[P + 1];
        int[] dist = new int[P+1], ans = new int[P+1];;
        char[][] arr = new char[N][M];
        
        for(int i = 1; i <= P; i++) 
        {
        	dist[i] = sc.nextInt();
        	q[i] = new LinkedList<>();
        }
        for(int i = 0; i < N; i++)
        {
        	arr[i] = sc.next().toCharArray();
        	for(int j = 0; j < M; j++)
        	{
        		if(arr[i][j] >= '1' && arr[i][j] <= '9')
        		{
        			q[arr[i][j]-'0'].add(new Pair(i, j));
        			ans[arr[i][j] - '0']++;
        		}
        	}
        }
        
        boolean flag = true;
        while(flag)
        {
        	flag = false;
        	
        	for(int i = 1; i <= P; i++)
        	{
        		for(int t = 0; t < dist[i]; t++)
    			{
        			int size = q[i].size();
        			if(size == 0) break;
            		while(size > 0)
            		{
            			Pair p = q[i].poll();
            			
            				for(int k = 0; k < 4; k++)
                			{
                				int nx = p.x + dx[k], ny = p.y + dy[k];
                				
                				if(nx >= 0 && ny >= 0 && nx < N && ny < M && arr[nx][ny] == '.')
                				{
                					flag = true;
                					ans[i]++;
                					arr[nx][ny] = (char)(i+'0');
                					q[i].add(new Pair(nx, ny));
                				}
                			}
            			size--;
            		}
    			}
        	}
        }
        
        for(int i = 1; i <= P; i++)
        	System.out.print(ans[i] + " ");
	}
}
class Pair{
	int x, y;
	Pair(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
}