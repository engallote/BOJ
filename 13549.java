import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int[] chk = new int[100001];
		Arrays.fill(chk, -1);
		chk[N] = 0;
		PriorityQueue<Integer> q = new PriorityQueue<>();
		q.add(N);
		
		while(!q.isEmpty())
		{
			int p = q.poll();
			if(p == K)
			{
				continue;
			}
			if(p * 2 <= 100000 && (chk[p * 2] == -1 || chk[p * 2] > chk[p]))
			{
				chk[p * 2] = chk[p];
				q.offer(p * 2);
			}
			if(p + 1 <= 100000 && (chk[p + 1] == -1 || chk[p + 1] > chk[p] + 1))
			{
				chk[p + 1] = chk[p] + 1;
				q.offer(p + 1);
			}
			if(p - 1 >= 0 && (chk[p - 1] == -1 || chk[p - 1] > chk[p] + 1))
			{
				chk[p - 1] = chk[p] + 1;
				q.offer(p - 1);
			}
		}
		System.out.println(chk[K]);
	}
}