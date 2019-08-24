import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N, M, sheep = 0, wolf = 0;
	static char[][] arr;
	static boolean[][] visit;
	static int[] dx = {0, 1, 0, -1}, dy = {1, 0, -1, 0};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new char[N][M];
		visit = new boolean[N][M];
		
		for(int i = 0; i < N; i++)
			arr[i] = sc.next().toCharArray();
		
		for(int i = 0; i < N; i++)
			for(int j = 0; j < M; j++)
				if(!visit[i][j] && arr[i][j] != '#')
					bfs(i, j);
				
		System.out.println(sheep + " " + wolf);
	}
	private static void bfs(int x, int y) {
		visit[x][y] = true;
		int s = 0, w = 0;
		if(arr[x][y] == 'v')
			w++;
		else if(arr[x][y] == 'k')
			s++;
		Queue<Pair> q = new LinkedList<>();
		q.offer(new Pair(x, y));
		while(!q.isEmpty())
		{
			Pair p = q.poll();
			for(int i = 0; i < 4; i++)
			{
				int nx = p.x + dx[i], ny = p.y + dy[i];
				if(nx < 0 || nx >= N || ny < 0 || ny >= M || visit[nx][ny] || arr[nx][ny] == '#')
					continue;
				else if(arr[nx][ny] == 'v')
					w++;
				else if(arr[nx][ny] == 'k')
					s++;
				visit[nx][ny] = true;
				q.offer(new Pair(nx, ny));
			}
		}
//		System.out.println(w + " "  + s);
		if(w >= s)
			wolf += w;
		else if(w < s)
			sheep += s;
	}
}
class Pair{
	int x, y;
	Pair(int x, int y){
		this.x = x;
		this.y = y;
	}
}