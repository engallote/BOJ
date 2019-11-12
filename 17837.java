import java.util.*;

public class Main {
	static int N, K;
	static int[][] map;
	static Pair[] arr;
	static Queue<Integer>[][] q;
	static boolean end = false;
	static int[] dx = {0, 0, 0, -1, 1}, dy = {0, 1, -1, 0, 0};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		map = new int[N+1][N+1];
		arr = new Pair[K + 1];
		q = new LinkedList[N+1][N+1];
		for(int i = 1; i <= N; i++)
		{
			q[i] = new LinkedList[N+1];
			for(int j = 1; j <= N; j++)
			{
				map[i][j] = sc.nextInt();
				q[i][j] = new LinkedList<Integer>();
			}
		}
		
		for(int i = 1; i <= K; i++)
		{
			int r = sc.nextInt();
			int c = sc.nextInt();
			int d = sc.nextInt();
			q[r][c].offer(i);
			arr[i] = new Pair(i, r, c, d);
		}
		
		int res = -1;
		for(int i = 1; i <= 1000; i++)
		{
			for(int j = 1; j <= K; j++)
			{
				move(arr[j]);
				if(end) break;
			}
			if(end)
			{
				res = i;
				break;
			}
		}
		System.out.println(res);
	}
	private static void move(Pair cur) {
		int nx = cur.x, ny = cur.y, nd = cur.d;
		boolean reverse = false;//맵에서 1에 도착할 경우
		if(nx + dx[nd] >= 1 && ny + dy[nd] >= 1 && nx + dx[nd] <= N && ny + dy[nd] <= N)
		{
			if(map[nx+dx[nd]][ny+dy[nd]] <= 1)//흰칸 또는 빨간칸
			{
				nx += dx[nd];
				ny += dy[nd];
				if(map[nx][ny] == 1) reverse = true;//빨간칸인 경우
			}
			else//파란칸
			{
				//방향전환
				if(nd == 1 || nd == 3) nd += 1;
				else nd -= 1;
				//맵 안이면서 흰칸 또는 빨간칸인 경우에만 움직임
				if((nx + dx[nd] >= 1 && ny + dy[nd] >= 1 && nx + dx[nd] <= N && ny + dy[nd] <= N) && map[nx+dx[nd]][ny+dy[nd]] <= 1)
				{
					nx += dx[nd];
					ny += dy[nd];
					if(map[nx][ny] == 1) reverse = true;//빨간칸인 경우
				}
				else
				{
					arr[cur.idx].d = nd;
					return;
				}
			}
		}
		else//맵 밖으로 나간 경우
		{
			//방향전환
			if(nd == 1 || nd == 3) nd += 1;
			else nd -= 1;
			//맵 안이면서 흰칸 또는 빨간칸인 경우에만 움직임
			if((nx + dx[nd] >= 1 && ny + dy[nd] >= 1 && nx + dx[nd] <= N && ny + dy[nd] <= N) && map[nx+dx[nd]][ny+dy[nd]] <= 1)
			{
				nx += dx[nd];
				ny += dy[nd];
				if(map[nx][ny] == 1) reverse = true;//빨간칸인 경우
			}
			else 
			{
				arr[cur.idx].d = nd;
				return;
			}
		}
		//해당 idx 아래의 말들을 임시 저장
		Queue<Integer> tmp = new LinkedList<Integer>();
		while(!q[cur.x][cur.y].isEmpty() && q[cur.x][cur.y].peek() != cur.idx)
			tmp.offer(q[cur.x][cur.y].poll());
		//현재 좌표 저장
		int tx = cur.x, ty = cur.y;
		//idx 저장할 큐
		Deque<Integer> dq = new LinkedList<Integer>();
		dq.offer(q[cur.x][cur.y].poll());
		//차례대로 말 큐에 넣고 좌표 수정
		while(!q[cur.x][cur.y].isEmpty())
		{
			int idx = q[cur.x][cur.y].poll();
			dq.offer(idx);
			arr[idx].x = nx;
			arr[idx].y = ny;
		}
		
		arr[cur.idx].x = nx;
		arr[cur.idx].y = ny;
		arr[cur.idx].d = nd;
		
		if(reverse)//빨간칸인 경우
		{
			while(!dq.isEmpty()) q[nx][ny].offer(dq.pollLast());
		}
		else//다른칸인 경우
		{
			while(!dq.isEmpty()) q[nx][ny].offer(dq.pollFirst());
		}
		
		q[tx][ty].addAll(tmp);//원래 좌표에 임시 저장했던 idx 넣어주기 
		if(q[nx][ny].size() >= 4) end = true;//4개 이상 모이는지 확인
	}
}
class Pair{
	int idx, x, y, d;
	Pair(int idx, int x, int y, int d)
	{
		this.idx = idx;
		this.x = x;
		this.y = y;
		this.d = d;
	}
}