import java.util.*;

public class Main {
	static int N, M, res = 0;
	static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
	static char[][] arr;
	static boolean[][] chk;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new char[2][200001];
		chk = new boolean[2][200001];
		
		for(int i = 0; i < 2; i++)
		{
			Arrays.fill(arr[i], '1');
			arr[i] = sc.next().toCharArray();
		}
		
		Queue<Pair> q = new LinkedList<Pair>();
		q.offer(new Pair(0, 0));
		
		int size = 0, res = 0, time = 0;
		while(!q.isEmpty())
		{
			size = q.size();
			for(int t = 0; t < size; t++)
			{
				Pair p = q.poll();
				if(p.y + 1 >= N || p.y + M >= N)
				{
					res = 1;
					q.clear();
					break;
				}
				if(p.y + 1 < N && arr[p.x][p.y+1] == '1' && !chk[p.x][p.y + 1])
				{
					chk[p.x][p.y + 1] = true;
					q.offer(new Pair(p.x, p.y + 1));
				}
				if(p.y - 1 > time && arr[p.x][p.y-1] == '1' && !chk[p.x][p.y - 1])
				{
					chk[p.x][p.y - 1] = true;
					q.offer(new Pair(p.x, p.y - 1));
				}
				if(p.x + 1 < 2 && p.y + M < N && arr[p.x+1][p.y+M] == '1' && !chk[p.x+1][p.y+M])
				{
					chk[p.x + 1][p.y + M] = true;
					q.offer(new Pair(p.x + 1, p.y + M));
				}
				if(p.x - 1 >= 0 && p.y + M < N && arr[p.x-1][p.y+M] == '1' && !chk[p.x-1][p.y+M])
				{
					chk[p.x - 1][p.y + M] = true;
					q.offer(new Pair(p.x - 1, p.y + M));
				}
			}
			time++;
		}
		System.out.println(res);
	}
}
class Pair{
	int x, y;
	Pair(int x, int y){
		this.x = x;
		this.y = y;
	}
}