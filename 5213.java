import java.util.*;

public class Main {
	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int num = 1, x = 0;
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		Pair[][] arr = new Pair[N][N];
		boolean flag = false;
		for(int i = 0; i < N; i++)
		{
			if(i % 2 == 0)
			{
				for(int j = 0; j < N; j++)
				{
					int a = sc.nextInt();
					int b = sc.nextInt();
					arr[i][j] = new Pair(num, i, j, a, b, 0);
					num++;
				}
			}
			else
			{
				for(int j = 0; j < N-1; j++)
				{
					int a = sc.nextInt();
					int b = sc.nextInt();
					arr[i][j] = new Pair(num, i, j, a, b, 0);
					num++;
				}
				arr[i][N-1] = new Pair(-1, -1, -1, -1, -1, 0);
			}
		}
		int[] chk = new int[num], path = new int[num];
		Arrays.fill(chk, Integer.MAX_VALUE);
		Arrays.fill(path, -1);
		chk[1] = 0;
		pq.offer(new Pair(1, 0, 0, arr[0][0].l, arr[0][0].r, 0));
		
		while(!pq.isEmpty())
		{
			Pair p = pq.poll();
			x = Math.max(x, p.idx);
			if(p.idx == num - 1)
			{
				flag = true;
				break;
			}
			
			if(p.y + 1 < N && p.r == arr[p.x][p.y+1].l && chk[arr[p.x][p.y+1].idx] > p.cnt + 1)
			{
				chk[arr[p.x][p.y+1].idx] = chk[p.idx] + 1;
				path[arr[p.x][p.y+1].idx] = p.idx;
				pq.offer(new Pair(p.idx + 1, p.x, p.y + 1, arr[p.x][p.y+1].l, arr[p.x][p.y+1].r, p.cnt + 1));
			}
			if(p.x + 1 < N)
			{
				if(p.x % 2 == 0)//N
				{
					if(p.r == arr[p.x+1][p.y].l && chk[arr[p.x+1][p.y].idx] > p.cnt + 1)
					{
						chk[arr[p.x+1][p.y].idx] = p.cnt + 1;
						path[arr[p.x+1][p.y].idx] = p.idx;
						pq.offer(new Pair(arr[p.x+1][p.y].idx, p.x+1, p.y, arr[p.x+1][p.y].l, arr[p.x+1][p.y].r, p.cnt + 1));
					}
					if(p.y - 1 >= 0 && arr[p.x+1][p.y-1].r == p.l && chk[arr[p.x+1][p.y-1].idx] > p.cnt + 1)
					{
						chk[arr[p.x+1][p.y-1].idx] = p.cnt + 1;
						path[arr[p.x+1][p.y-1].idx] = p.idx;
						pq.offer(new Pair(arr[p.x+1][p.y-1].idx, p.x+1, p.y-1, arr[p.x+1][p.y-1].l, arr[p.x+1][p.y-1].r, p.cnt + 1));
					}
				}
				else//N-1
				{
					if(p.l == arr[p.x+1][p.y].r && chk[arr[p.x+1][p.y].idx] > p.cnt + 1)
					{
						chk[arr[p.x+1][p.y].idx] = p.cnt + 1;
						path[arr[p.x+1][p.y].idx] = p.idx;
						pq.offer(new Pair(arr[p.x+1][p.y].idx, p.x+1, p.y, arr[p.x+1][p.y].l, arr[p.x+1][p.y].r, p.cnt + 1));
					}
					if(p.y + 1 < N && arr[p.x+1][p.y+1].l == p.r && chk[arr[p.x+1][p.y+1].idx] > p.cnt + 1)
					{
						chk[arr[p.x+1][p.y+1].idx] = p.cnt + 1;
						path[arr[p.x+1][p.y+1].idx] = p.idx;
						pq.offer(new Pair(arr[p.x+1][p.y+1].idx, p.x+1, p.y+1, arr[p.x+1][p.y+1].l, arr[p.x+1][p.y+1].r, p.cnt + 1));
					}
				}
			}
			if(p.y - 1 >= 0 && p.l == arr[p.x][p.y-1].r && chk[arr[p.x][p.y-1].idx] > p.cnt + 1)
			{
				chk[arr[p.x][p.y-1].idx] = p.cnt + 1;
				path[arr[p.x][p.y-1].idx] = p.idx;
				pq.offer(new Pair(arr[p.x][p.y-1].idx, p.x, p.y-1, arr[p.x][p.y-1].l, arr[p.x][p.y-1].r, p.cnt + 1));
			}
			if(p.x - 1 >= 0)
			{
				if(p.x % 2 == 0)//N
				{
					if(p.r == arr[p.x-1][p.y].l && chk[arr[p.x-1][p.y].idx] > p.cnt + 1)
					{
						chk[arr[p.x-1][p.y].idx] = p.cnt + 1;
						path[arr[p.x-1][p.y].idx] = p.idx;
						pq.offer(new Pair(arr[p.x-1][p.y].idx, p.x-1, p.y, arr[p.x-1][p.y].l, arr[p.x-1][p.y].r, p.cnt + 1));
					}
					if(p.y - 1 >= 0 && arr[p.x-1][p.y-1].r == p.l && chk[arr[p.x-1][p.y-1].idx] > p.cnt + 1)
					{
						chk[arr[p.x-1][p.y-1].idx] = p.cnt + 1;
						path[arr[p.x-1][p.y-1].idx] = p.idx;
						pq.offer(new Pair(arr[p.x-1][p.y-1].idx, p.x-1, p.y-1, arr[p.x-1][p.y-1].l, arr[p.x-1][p.y-1].r, p.cnt + 1));
					}
				}
				else//N-1
				{
					if(arr[p.x-1][p.y].r == p.l && chk[arr[p.x-1][p.y].idx] > p.cnt + 1)
					{
						chk[arr[p.x-1][p.y].idx] = p.cnt + 1;
						path[arr[p.x-1][p.y].idx] = p.idx;
						pq.offer(new Pair(arr[p.x-1][p.y].idx, p.x-1, p.y, arr[p.x-1][p.y].l, arr[p.x-1][p.y].r, p.cnt + 1));
					}
					if(p.y + 1 < N && arr[p.x-1][p.y+1].l == p.r && chk[arr[p.x-1][p.y+1].idx] > p.cnt + 1)
					{
						chk[arr[p.x-1][p.y+1].idx] = p.cnt + 1;
						path[arr[p.x-1][p.y+1].idx] = p.idx;
						pq.offer(new Pair(arr[p.x-1][p.y+1].idx, p.x-1, p.y+1, arr[p.x-1][p.y+1].l, arr[p.x-1][p.y+1].r, p.cnt + 1));
					}
				}
			}
		}
		
		Stack<Integer> st = new Stack<>();
		st.push(x);
		while(path[x] != -1)
		{
			st.push(path[x]);
			x = path[x];
		}
		System.out.println(st.size());
		while(!st.isEmpty())
			System.out.print(st.pop() + " ");
	}
}
class Pair implements Comparable<Pair>{
	int idx, x, y, l, r, cnt;
	Pair(int idx, int x, int y, int l, int r, int cnt)
	{
		this.idx = idx;
		this.x = x;
		this.y = y;
		this.l = l;
		this.r = r;
		this.cnt = cnt;
	}
	@Override
	public int compareTo(Pair o) {
		return o.cnt > this.cnt ? -1 : 1;
	}
}