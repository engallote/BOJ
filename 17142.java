import java.util.*;
 
public class Main {
    static int N, M, res, len;
    static int[][] arr, tmp;
    static boolean[] chk;
    static boolean[][] visit;
    static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
    static ArrayList<Pair> empty = new ArrayList<>(), aly = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[N][N];
        tmp = new int[N][N];
        visit = new boolean[N][N];
        res = Integer.MAX_VALUE;
        for(int i = 0; i < N; i++)
        	for(int j = 0; j < N; j++)
        	{
        		arr[i][j] = sc.nextInt();
        		if(arr[i][j] == 0) empty.add(new Pair(i, j));
        		else if(arr[i][j] == 2) aly.add(new Pair(i, j));
        	}
        if(empty.isEmpty())
        {
        	System.out.println(0);
        	return;
        }
        len = aly.size();
        chk = new boolean[len];
        for(int i = 0; i < len; i++)
        {
        	Arrays.fill(chk, false);
        	chk[i] = true;
        	solve(i + 1, 1);
        }
        if(res == Integer.MAX_VALUE) res = -1;
        System.out.println(res);
    }
	private static void solve(int idx, int cnt) {
		if(cnt == M)
		{
			run();
			return;
		}
		
		for(int i = idx; i < len; i++)
			if(!chk[i])
			{
				chk[i] = true;
				solve(i + 1, cnt + 1);
				chk[i] = false;
			}
	}
	private static void run() {
		Queue<Pair> q = new LinkedList<>();
		for(int i = 0; i < N; i++)
		{
			Arrays.fill(visit[i], false);
			Arrays.fill(tmp[i], Integer.MAX_VALUE);
		}
		
		for(int i = 0; i < len; i++)
			if(chk[i])
			{
				tmp[aly.get(i).x][aly.get(i).y] = 0;
				q.add(aly.get(i));
				visit[aly.get(i).x][aly.get(i).y] = true;
			}
		
		boolean flag = true;
		for(Pair p : empty)
			if(!visit[p.x][p.y])
			{
				flag = false;
				break;
			}
		if(flag)
			return;
		int time = 0, size = 0;
		while(!q.isEmpty())
		{
			size = q.size();
			flag = true;
			for(int t = 0; t < size; t++)
			{
				Pair p = q.poll();
				for(int i = 0; i < 4; i++)
				{
					int nx = p.x + dx[i], ny = p.y + dy[i];
					if(nx < 0 || ny < 0 || nx >= N || ny >= N || arr[nx][ny] == 1 || visit[nx][ny])
						continue;
					tmp[nx][ny] = Math.min(tmp[nx][ny], time + 1);
					visit[nx][ny] = true;
					q.add(new Pair(nx, ny));
				}
			}
			
			for(Pair p : empty)
				if(!visit[p.x][p.y])
				{
					flag = false;
					break;
				}
//			for(Pair p : aly)
//				if(!visit[p.x][p.y])
//				{
//					flag = false;
//					break;
//				}
			time++;
			if(flag) break;
		}
		
//		for(int i = 0; i < N; i++)
//		{
//			for(int j = 0; j < N; j++)
//			{
//				if(arr[i][j] == 1) System.out.print("- ");
//				else System.out.print(tmp[i][j] + " ");
//			}
//			System.out.println();
//		}
//		System.out.println("----------");
		if(flag)
			res = Math.min(res, time);
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