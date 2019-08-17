import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		int N = sc.nextInt();
		int[] arr = new int[N];
		
		for(int i = 0; i < N; i++)
			arr[i] = sc.nextInt();
		int[] chk = new int[1001];
		Arrays.fill(chk, 1000000000);
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		pq.add(new Pair(A, 0));
		chk[A] = 0;
		while(!pq.isEmpty())
		{
			Pair p = pq.poll();
			if(p.x == B)
			{
				System.out.println(p.cnt);
				break;
			}
			
			if(p.x + 1 <= B && chk[p.x + 1] > p.cnt + 1)
			{
				chk[p.x + 1] = p.cnt + 1;
				pq.add(new Pair(p.x + 1, p.cnt + 1));
			}
			if(p.x - 1 >= 1 && chk[p.x - 1] > p.cnt + 1)
			{
				chk[p.x - 1] = p.cnt + 1;
				pq.add(new Pair(p.x - 1, p.cnt + 1));
			}
			int tmp = Math.abs(p.x - B);
			for(int i = 0; i < N; i++)
			{
				int sub = Math.abs(arr[i] - B);
				if(tmp > sub && chk[arr[i]] > p.cnt + 1)
				{
					chk[arr[i]] = p.cnt + 1;
					pq.add(new Pair(arr[i], p.cnt + 1));
				}
			}
		}
	}
}
class Pair implements Comparable<Pair>{
	int x, cnt;
	Pair(int x, int cnt)
	{
		this.x = x;
		this.cnt = cnt;
	}
	@Override
	public int compareTo(Pair o) {
		return o.cnt > this.cnt ? -1 : 1;
	}
}