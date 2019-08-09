import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int len = Integer.toString(N).length();
		int K = sc.nextInt();
		if(len == 1 || (len == 2 && N % 10 == 0))
		{
			System.out.println(-1);
			return;
		}
		boolean[][] visit = new boolean[1000001][K+1];
		int max = 0;
		Queue<Pair> q = new LinkedList<>();
		q.offer(new Pair(N, K));
		visit[N][K] = true;
		while(!q.isEmpty())
		{
			Pair p = q.poll();
			if(p.k == 0)
			{
				if(max < p.n)
					max = p.n;
			}
			else
			{
				String n = Integer.toString(p.n);
				for(int i = 0; i < n.length(); i++)
				{
//					System.out.println(n.charAt(i) + " >>>>");
					for(int j = 0; j < n.length(); j++)
					{
						if(i != j && ((i == 0 && n.charAt(j) - '0' != 0) || (i > 0)))
						{
							char[] c = n.toCharArray();
							int tmp = swap(c, i, j);
							if(visit[tmp][p.k-1]) continue;
							visit[tmp][p.k-1] = true;
							q.offer(new Pair(tmp, p.k - 1));
							K = Math.min(K, p.k-1);
						}
					}
				}
			}
		}
		System.out.println(max);
	}

	private static int swap(char[] n, int i, int j) {
		char a = n[i];
		char b = n[j];
		char[] c = n;
//		for(int x = 0; x < c.length; x++)
//			System.out.print(n[x]);
//		System.out.print("    ");
		c[i] = b;
		c[j] = a;
		if(c[0] == 0) return 0;
		else
		{
			String tmp = "";
			
			for(int x = 0; x < c.length; x++)
			{
//				System.out.print(c[x]);
				tmp += c[x];
			}
//			System.out.println();
			return Integer.parseInt(tmp);
		}
	}
}
class Pair{
	int n, k;
	Pair(int n, int k){
		this.n = n;
		this.k = k;
	}
}