import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Pair[] arr = new Pair[N];
		for(int i = 0; i < N; i++) 
			arr[i] = new Pair(i+1, sc.nextInt(), sc.nextInt(), sc.nextInt());
		
		Arrays.sort(arr);
		System.out.println(arr[0].idx);
	}
}
class Pair implements Comparable<Pair>{
	int idx, s, cnt, time;
	Pair(int idx, int s, int cnt, int time)
	{
		this.idx = idx;
		this.s = s;
		this.cnt = cnt;
		this.time = time;
	}
	@Override
	public int compareTo(Pair o) {
		if(o.s > this.s) return 1;
		else if(o.s == this.s)
		{
			if(o.cnt > this.cnt) return -1;
			else if(o.cnt == this.cnt) return o.time > this.time ? -1 : 1;
			else return 1;
		}
		else return -1;
	}
}