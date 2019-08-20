import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N+1];
		int len = N * (N-1) / 2;
		for(int i = 0; i < len; i++)
		{
			int A = sc.nextInt();
			int B = sc.nextInt();
			int a = sc.nextInt();
			int b = sc.nextInt();
			if(a > b)
				arr[A]+=3;
			else if(a < b)
				arr[B]+=3;
			else
			{
				arr[A]++;
				arr[B]++;
			}
		}
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		for(int i = 1; i <= N; i++)
			pq.add(new Pair(i, arr[i]));
		int[] ans = new int[N+1];
		int rate = 1, cnt = 0;
		int preWin = 0;
		while(!pq.isEmpty())
		{
			int num = pq.peek().idx;
			int win = pq.poll().win;
			
			if(win == preWin)
			{
				ans[num] = rate;
				cnt++;
			}
			else
			{
				preWin = win;
				rate+= cnt;
				if(rate > N) rate = N;
				ans[num] = rate;
				cnt = 1;
			}
		}
		
		for(int i = 1; i <= N; i++)
			System.out.println(ans[i]);
	}
}
class Pair implements Comparable<Pair>{
	int idx, win;
	Pair(int idx, int win){
		this.idx = idx;
		this.win = win;
	}
	@Override
	public int compareTo(Pair o) {
		return o.win > this.win ? 1 : -1;
	}
}