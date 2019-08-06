import java.util.*;

public class Main {
	static int N, M, res = 1000000000;
	static boolean[][] visit;
	static int[][] arr;
	static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		int cnt = 0;
		arr = new int[N][M];
		visit = new boolean[N][M];
		for(int i = 0; i < N; i++)
		{
			char[] ch = sc.next().toCharArray();
			for(int j = 0; j < M; j++)
				arr[i][j] = ch[j] - '0';
		}
		visit[0][0] = true;
		Queue<Pair> q = new LinkedList<>();
		q.offer(new Pair(0, 0));
		boolean flag = true;
		while(flag)
		{
			int size = q.size();
			for(int i = 0; i < size; i++)
			{
				Pair p = q.poll();
				
				if(p.x == N - 1 && p.y == M - 1)
				{
					flag = false;
					break;
				}
				for(int j = 0; j < 4; j++)
				{
					int nx = p.x + dx[j], ny = p.y + dy[j];
					if(nx < 0 || ny < 0 || nx >= N || ny >= M || arr[nx][ny] == 0 || visit[nx][ny])
						continue;
					visit[nx][ny] = true;
					q.offer(new Pair(nx, ny));
				}
			}
			cnt++;
		}
		System.out.println(cnt);
	}
}
class Pair{
	int x, y;
	Pair(int x, int y){
		this.x = x;
		this.y =y;
	}
}