import java.util.*;

public class Main {
	static int N, M, D, res = 0;
	static int[][] arr;
	static int[] ach = new int[3];
	static int[] chk;
	static boolean[] visit;
	static ArrayList<Pair> ene = new ArrayList<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		D = sc.nextInt();
		arr = new int[N][M];
		visit = new boolean[M];
		
		for(int i = 0; i < N; i++)
			for(int j = 0; j < M; j++)
			{
				arr[i][j] = sc.nextInt();
				if(arr[i][j] == 1) ene.add(new Pair(i, j));
			}
			
		chk = new int[ene.size()];
		solve(0);
		System.out.println(res);
	}
	private static void solve(int dep) {
		if(dep == 3)
		{
			play();
			return;
		}
		
		for(int j = 0; j < M; j++)
			if(!visit[j])
			{
				visit[j] = true;
				ach[dep] = j;
				solve(dep + 1);
				ach[dep] = -1;
				visit[j] = false;
			}
	}
	private static void play() {
		Pair[] tmp = new Pair[ene.size()];
		for(int i = 0; i < ene.size(); i++)
			tmp[i] = new Pair(ene.get(i).x, ene.get(i).y);
		Arrays.fill(chk, 0);
		int sum = 0, idx = 0, x = 0, y = 0, cnt = 0, cnt2 = 0;
		boolean flag = true;
		while(flag)
		{
			flag = false;
			for(int i = 0; i < 3; i++)
			{
				sum = Integer.MAX_VALUE;
				idx = -1;
				x = sum;
				y = sum;
				for(int j = 0; j < tmp.length; j++)
				{
					if(chk[j] == 2) continue;
					int num = Math.abs(N - tmp[j].x) + Math.abs(ach[i] - tmp[j].y);
//					System.out.println(tmp[j].x + ", " + tmp[j].y + " >> " + num);
					if(num > D) continue;
					if(sum > num)
					{
						sum = num;
						idx = j;
						x = tmp[j].x;
						y = tmp[j].y;
					}
					else if(sum == num && y > tmp[j].y)
					{
						idx = j;
						x = tmp[j].x;
						y = tmp[j].y;
					}
				}
				if(idx != -1)
				{
//					System.out.println(ach[i] + " @--------> " + tmp[idx].y);
					chk[idx] = 1;
				}
			}
			
			for(int i = 0; i < tmp.length; i++)
				if(chk[i] == 1)
				{
					chk[i] = 2;
					cnt2++;
				}
			for(int i = 0; i < tmp.length; i++)
			{
				if(chk[i] == 2) continue;
				tmp[i].x += 1;
				if(tmp[i].x >= N)
				{
					chk[i] = 2;
					cnt++;
					continue;
				}
				flag = true;
			}
		}
		res = Math.max(res, cnt2);
	}
}
class Pair{
	int x, y;
	Pair(int x, int y){
		this.x = x;
		this.y = y;
	}
}