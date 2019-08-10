import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int cnt = 0, min = 1000000000;
		
		int[] chk = new int[100001];
		Arrays.fill(chk, -1);
		chk[N] = 0;
		
		Queue<Integer> q = new LinkedList<>();
		q.add(N);
		
		while(!q.isEmpty())
		{
			int x = q.poll();
			if(x == K)
			{
//				System.out.println(chk[K]);
				if(chk[K] < min)
				{
					min = chk[K];
					cnt = 1;
				}
				else if(chk[K] == min)
					cnt++;
				continue;
			}
			if(x * 2 <= 100000 && (chk[x*2] < 0 || chk[x*2] >= chk[x] + 1))
			{
				chk[x*2] = chk[x] + 1;
				q.offer(x*2);
			}
			if(x + 1 <= 100000 && (chk[x+1] < 0 || chk[x+1] >= chk[x] + 1))
			{
				chk[x+1] = chk[x] + 1;
				q.offer(x+1);
			}
			if(x - 1 >= 0 && (chk[x-1] < 0 || chk[x-1] >= chk[x] + 1))
			{
				chk[x-1] = chk[x] + 1;
				q.offer(x-1);
			}
		}
		
		System.out.println(min);
		System.out.println(cnt);
	}
}