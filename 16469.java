import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
	static int R, C, min, count;
	static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
	static int[][] arr, visit;
	static int[][][] sumArr;
	static Vector<Pair> v;
	public static void main(String[] args) throws IOException{
//        Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		arr = new int[R][C];
		visit = new int[R][C];
		sumArr = new int[R][C][3];
		v = new Vector<>();
		count = 0;
		min = Integer.MAX_VALUE;
		for(int i = 0; i < R; i++)
		{
			char[] c = br.readLine().toCharArray();
			for(int j = 0; j < C; j++)
				arr[i][j] = c[j] - '0';
		}
		
		for(int i = 0; i < 3; i++)
		{
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;
			v.add(new Pair(x, y));
		}
		
		int cnt = 1;
		for(int i = 0; i < R; i++)
			for(int j = 0; j < C; j++)
				if(visit[i][j] == 0 && arr[i][j] == 0)
				{
					dfs(i, j, cnt);
					cnt++;
				}
		
		for(int i = 1; i < 3; i++)
		{
			if(visit[v.get(i-1).x][v.get(i-1).y] != visit[v.get(i).x][v.get(i).y])
			{
				bw.write("-1");
				bw.flush();
				return;
			}
		}
		
		find();
		
//		for(int i = 0; i < R; i++)
//		{
//			for(int j = 0; j < C; j++)
//			{
//				System.out.print(sumArr[i][j][0] + "," + sumArr[i][j][1] + "," + sumArr[i][j][2] + " ");
//			}
//			System.out.println();
//		}

		int minSum = Integer.MAX_VALUE;
		for(int i = 0; i < R; i++)
			for(int j = 0; j < C; j++)
			{
				if(arr[i][j] == 1 || visit[i][j] != visit[v.get(0).x][v.get(0).y]) continue;
				int tmp = Math.max(sumArr[i][j][0], Math.max(sumArr[i][j][1], sumArr[i][j][2]));
				if(tmp < min)
				{
					min = tmp;
					count = 1;
				}
				else if(min == tmp)
					count++;
//				System.out.println(sum + " " + tmp);
			}
				
		if(min == Integer.MAX_VALUE)
			bw.write("-1");
		else
			bw.write(min+"\n"+count);
        bw.flush();
    }
	private static void dfs(int x, int y, int num) {
		visit[x][y] = num;
		
		for(int i = 0; i < 4; i++)
		{
			int nx = x + dx[i], ny = y + dy[i];
			if(nx < 0 || ny < 0 || nx >= R || ny >= C || visit[nx][ny] != 0 || arr[nx][ny] == 1)
				continue;
			dfs(nx, ny, num);
		}
		
	}
	private static void find() {
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		boolean[][] chk;
		
		for(int i = 0; i < 3; i++)
		{
			Pair p2 = v.get(i);
			pq.add(new Pair(p2.x, p2.y, 0));
			sumArr[p2.x][p2.y][i] = 0;
			chk = new boolean[R][C];
			chk[p2.x][p2.y] = true;
			while(!pq.isEmpty())
			{
				Pair p = pq.poll();
				
				for(int k = 0; k < 4; k++)
				{
					int nx = p.x + dx[k], ny = p.y + dy[k];
					if(nx < 0 || ny < 0 || nx >= R || ny >= C || chk[nx][ny] || arr[nx][ny] == 1)
						continue;
					chk[nx][ny] = true;
					sumArr[nx][ny][i] = p.cnt + 1;
					pq.add(new Pair(nx, ny, p.cnt + 1));
				}
			}
			pq.clear();
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