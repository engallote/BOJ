import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		PriorityQueue<Pair> q = new PriorityQueue<>();
		
		int max = 0;
		for(int i = 0; i < N; i++)
		{
			int c = sc.nextInt();
			max = Math.max(max, c);
			q.add(new Pair(c, sc.nextInt(), sc.nextInt()));
		}
		
		int[] arr = new int[max+1];
		int cnt = 0;
		while(cnt < 3)
		{
			Pair p = q.poll();
			if(arr[p.c] == 2) continue;
			System.out.println(p.c + " " + p.n);
			arr[p.c]++;
			cnt++;
		}
	}
}
class Pair implements Comparable<Pair>{
	int c, n, s;
	Pair(int c, int n, int s){
		this.c = c;
		this.n = n;
		this.s = s;
	}
	@Override
	public int compareTo(Pair o) {
		if(o.s > this.s) return 1;
		else return -1;
	}
}