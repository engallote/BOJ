import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true)
		{
			int N = sc.nextInt();
			int M = sc.nextInt();
			if(N == 0 && M == 0) break;
			Pair[] arr = new Pair[N];
			for(int i = 0; i < N; i++)
			{
				int source = sc.nextInt();
				int destination = sc.nextInt();
				int start = sc.nextInt();
				int duration = sc.nextInt();
				arr[i] = new Pair(start, duration);
			}
			
			Arrays.sort(arr);
			int start, duration, end, cnt;
			for(int i = 0; i < M; i++)
			{
				start = sc.nextInt();
				duration = sc.nextInt();
				end = start + duration;
				cnt = 0;
				for(int j = 0; j < N; j++)
				{
					if(end < arr[j].s) break;
					else if((arr[j].s >= start && arr[j].s < end) || (arr[j].s < start && arr[j].s + arr[j].d > start))
						cnt++;
				}
				System.out.println(cnt);
			}
		}
	}
}
class Pair implements Comparable<Pair>{
	int s, d;
	Pair(int s, int d)
	{
		this.s = s;
		this.d = d;
	}
	@Override
	public int compareTo(Pair o) {
		if(o.s > this.s) return -1;
		else if(o.s == this.s)
		{
			if(o.d > this.d) return -1;
			else if(o.d == this.d) return 0;
			else return 1;
		}
		else return 1;
	}
}