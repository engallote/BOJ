import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean[] chk = new boolean[10000];
		
		for(int i = 2; i < 10000; i++)
		{
			if(chk[i]) continue;
			for(int j = i + i; j < 10000; j+=i)
				chk[j] = true;
		}
		
		int tc = sc.nextInt();
		
		for(int t = 0; t < tc; t++)
		{
			int a = sc.nextInt();
			int b = sc.nextInt();
			boolean[] visit = new boolean[10000];
			Queue<Pair> q = new LinkedList<>();
			q.add(new Pair(a, 0));
			int[] arr = new int[4];
			
			boolean flag = false;
			while(!q.isEmpty())
			{
				Pair p = q.poll();
				if(p.n == b)
				{
					System.out.println(p.cnt);
					flag = true;
				}
				if(flag) break;
				
				arr[0] = p.n / 1000;
				arr[1] = (p.n % 1000) / 100;
				arr[2] = (p.n % 100) / 10;
				arr[3] = p.n % 10;
				for(int i = 1; i <= 9; i++)
				{
					int num = i * 1000 + arr[1] * 100 + arr[2] * 10 + arr[3];
					if(!chk[num] && !visit[num])
					{
						visit[num] = true;
						q.offer(new Pair(num, p.cnt + 1));
					}
				}
				for(int i = 0; i <= 9; i++)
				{
					int num = arr[0] * 1000 + i * 100 + arr[2] * 10 + arr[3];
					if(!chk[num] && !visit[num])
					{
						visit[num] = true;
						q.offer(new Pair(num, p.cnt + 1));
					}
				}
				for(int i = 0; i <= 9; i++)
				{
					int num = arr[0] * 1000 + arr[1] * 100 + i * 10 + arr[3];
					if(!chk[num] && !visit[num])
					{
						visit[num] = true;
						q.offer(new Pair(num, p.cnt + 1));
					}
				}
				for(int i = 0; i <= 9; i++)
				{
					int num = arr[0] * 1000 + arr[1] * 100 + arr[2] * 10 + i;
					if(!chk[num] && !visit[num])
					{
						visit[num] = true;
						q.offer(new Pair(num, p.cnt + 1));
					}
				}
			}
			if(!flag)
				System.out.println("impossible");
		}
	}
}
class Pair{
	int n, cnt;
	Pair(int n, int cnt){
		this.n = n;
		this.cnt = cnt;
	}
}