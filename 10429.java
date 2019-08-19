import java.util.*;

public class Main {
	static int N, M;
	static boolean flag = false;
	static boolean[][] chk;
	static char[][] arr = new char[3][3];
	static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        
        for(int i = 0; i < 3; i++)
        	arr[i] = sc.next().toCharArray();
        
        Vector<Pair> path = new Vector<>();
        for(int i = 0; i < 3; i++)
        {
        	for(int j = 0; j < 3; j++)
        	{
        		if(arr[i][j] >= '1' && arr[i][j] <= '9')
        		{
        			path.clear();
        			path.add(new Pair(i, j));
        			chk = new boolean[3][3];
        			chk[i][j] = true;
        			solve(i, j, (arr[i][j] - '0'), 1, 1, '+', path);  
        		}
        		if(flag) break;
        	}
        	if(flag) break;
        }
        if(!flag)
        	System.out.println(0);
    }
	private static void solve(int x, int y, int sum, int cnt, int pre, char c, Vector<Pair> path) {
		if(flag) return;
		if(cnt == M)
		{
			if(sum == N)
			{
				flag = true;
				System.out.println(1);
				for(Pair p : path)
					System.out.println(p.x + " " + p.y);
			}
			return;
		}
		
		for(int i = 0; i < 4; i++)
		{
			int nx = x + dx[i], ny = y + dy[i];
			if(nx < 0 || ny < 0 || nx >= 3 || ny >= 3 || chk[nx][ny]) continue;
			if(pre == 0)//숫자를 골라야 함
			{
				chk[nx][ny] = true;
				path.add(new Pair(nx, ny));
				if(c == '+')
					solve(nx, ny, sum + (arr[nx][ny] - '0'), cnt + 1, 1, c, path);
				else
					solve(nx, ny, sum - (arr[nx][ny] - '0'), cnt + 1, 1, c, path);
				path.remove(path.size()-1);
				chk[nx][ny] = false;
			}
			else//부호를 골라야 함
			{
				chk[nx][ny] = true;
				path.add(new Pair(nx, ny));
				solve(nx, ny, sum, cnt, 0, arr[nx][ny], path);
				path.remove(path.size()-1);
				chk[nx][ny] = false;
			}
		}
	}
}
class Pair{
	int x, y;
	Pair(int x, int y){
		this.x = x;
		this.y = y;
	}
}