import java.util.*;

public class Main {
	static int len, N;
	static boolean[] chk;
	static char[] c;
	static PriorityQueue<Integer> pq = new PriorityQueue<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		c = Integer.toString(N).toCharArray();
		len = c.length;
		chk = new boolean[len];
		solve("", 0);
		if(pq.isEmpty()) System.out.println(0);
		else System.out.println(pq.peek());
	}
	private static void solve(String num, int cnt) {
		if(cnt == len)
		{
			int n = Integer.parseInt(num);
			if(!pq.contains(n) && N < n)
				pq.add(n);
			return;
		}
		
		for(int i = 0; i < len; i++)
			if(!chk[i])
			{
				chk[i] = true;
				solve(num +""+ c[i], cnt + 1);
				chk[i] = false;
			}
	}
}