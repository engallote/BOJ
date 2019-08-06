import java.util.*;

public class Main {
	static int N;
	static int[][] arr;
	static Fish fish = new Fish(0, 0, 0);
	static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
	static ArrayList<Fish> aly = new ArrayList<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N][N];
		for(int i = 0; i < N; i++)
			for(int j = 0; j < N; j++)
			{
				arr[i][j] = sc.nextInt();
				if(arr[i][j] == 9)
				{
					arr[i][j] = 0;
					fish = new Fish(i, j, 2);
				}
				else if(arr[i][j] >= 1 && arr[i][j] <= 6)
					aly.add(new Fish(i, j, arr[i][j]));
			}
		Collections.sort(aly);
		boolean flag = true;
		int res = 0, cnt = 0;
		while(flag)
		{
			flag = false;
			int min = Integer.MAX_VALUE, x = Integer.MAX_VALUE, y = Integer.MAX_VALUE, idx = -1;
			for(int i = 0; i < aly.size(); i++)
			{
				Fish p = aly.get(i);
				if(p.w < fish.w)
				{
					int sum = bfs(p);
					if(sum < min)
					{
						flag = true;
						min = sum;
						idx = i;
						x = p.x;
						y = p.y;
					}
					else if(sum == min && x > p.x)
					{
						idx = i;
						x = p.x;
						y = p.y;
					}
					else if(sum == min && x == p.x && y > p.y)
					{
						idx = i;
						x = p.x;
						y = p.y;
					}
				}
				else break;
			}
			if(flag)
			{
				cnt++;
				res += min;
				arr[x][y] = 0;
				fish.x = x;
				fish.y = y;
				if(cnt == fish.w)
				{
					fish.w = fish.w + 1;
					cnt = 0;
				}
				aly.remove(idx);
				Collections.sort(aly);
			}
		}
		System.out.println(res);
	}
	private static int bfs(Fish p) {
		PriorityQueue<Fish> find = new PriorityQueue<>();
		find.add(new Fish(fish.x, fish.y, 0));
		boolean[][] chk = new boolean[N][N];
		chk[fish.x][fish.y] = true;

		while(!find.isEmpty())
		{
			Fish f = find.poll();
			if(f.x == p.x && f.y == p.y) return f.w;
			
			for(int i = 0; i < 4; i++)
			{
				int nx = f.x + dx[i], ny = f.y + dy[i];
				if(nx < 0 || ny < 0 || nx >= N || ny >= N || arr[nx][ny] > fish.w || chk[nx][ny]) 
					continue;
				chk[nx][ny] = true;
				find.add(new Fish(nx, ny, f.w + 1));
			}
		}
		return Integer.MAX_VALUE;
	}
}
class Fish implements Comparable<Fish>{
	int idx, x, y, w;
	Fish(int x, int y, int w)
	{
		this.x = x;
		this.y = y;
		this.w = w;
	}
	@Override
	public int compareTo(Fish o) {
		if(o.w > this.w) return -1;
		else if(o.w == this.w)
		{
			if(o.x > this.x) return -1;
			else if(o.x == this.x)
			{
				if(o.y > this.y) return -1;
				else return 1;
			}
			else return 1;
		}
		else return 1;
	}
}