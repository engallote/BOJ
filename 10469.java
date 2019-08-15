import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[][] arr = new char[8][8];
		Queue<Pair> q = new LinkedList<>();
		
		for(int i = 0; i < 8; i++)
		{
			arr[i] = sc.next().toCharArray();
			for(int j = 0; j < 8; j++)
				if(arr[i][j] == '*')
					q.add(new Pair(i, j));
		}
		int[] dx = {1, 0, -1, 0, 1, 1, -1, -1}, dy = {0, 1, 0, -1, 1, -1, 1, -1};
		boolean flag = true;
		
		if(q.size() != 8)
		{
			System.out.println("invalid");
			return;
		}
		while(!q.isEmpty())
		{
			Pair p = q.poll();
			
			for(int i = 0; i < 8; i++)
			{
				int nx = p.x + dx[i], ny = p.y + dy[i];
				
				while(nx >= 0 && ny >= 0 && nx < 8 && ny < 8)
				{
					if(arr[nx][ny] == '*')
					{
						flag = false;
						break;
					}
					nx += dx[i];
					ny += dy[i];
				}
				if(!flag) break;
			}
			if(!flag) break;
		}
		
		System.out.println(flag ? "valid" : "invalid");
	}
}
class Pair{
	int x, y;
	Pair(int x, int y){
		this.x = x;
		this.y = y;
	}
}