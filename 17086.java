import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
//		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] dx = {1, 0, -1, 0, 1, 1, -1, -1}, dy = {0, 1, 0, -1, 1, -1, 1, -1};
		int[][] arr = new int[N][M], chk = new int[N][M];
		Queue<Pair> q = new LinkedList<>();
		for(int i = 0; i < N; i++)
		{
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++)
			{
				chk[i][j] = 100000000;
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j] == 1) 
				{
					q.add(new Pair(i, j));
					chk[i][j] = 0;
				}
			}
		}
		
		int res = 0, size = 0;
		
		while(!q.isEmpty())
		{
			size = q.size();
			
			for(int t = 0; t < size; t++)
			{
				Pair p = q.poll();
				for(int i = 0; i < 8; i++)
				{
					int nx = p.x + dx[i], ny = p.y + dy[i];
					if(nx < 0 || ny < 0 || nx >= N || ny >= M || chk[nx][ny] <= chk[p.x][p.y] + 1) continue;
					chk[nx][ny] = chk[p.x][p.y] + 1;
					q.add(new Pair(nx, ny));
				}
			}
		}
		
		for(int i = 0; i < N; i++)
		{
			for(int j = 0; j < M; j++)
			{
				res = Math.max(res, chk[i][j]);
//				System.out.print(chk[i][j] + " ");
			}
//			System.out.println();
		}
		bw.write(res+"");
		bw.flush();
	}
}
class Pair{
	int x, y;
	Pair(int x, int y){
		this.x = x;
		this.y = y;
	}
}