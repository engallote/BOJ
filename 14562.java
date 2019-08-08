import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int a = sc.nextInt();
			int b = sc.nextInt();
			int[][] chk = new int[900][900];
			for(int i = 0; i < 900; i++)
				Arrays.fill(chk[i], -1);
			chk[a][b] = 0;
			Queue<Pair> q = new LinkedList<Pair>();
			q.add(new Pair(a, b));
			while(!q.isEmpty())
			{
				Pair p = q.poll();
				
				if(p.a == p.b)
				{
					System.out.println(chk[p.a][p.b]);
					break;
				}
				
				if(p.a * 2 < 900 && p.b + 3 < 900 && chk[p.a * 2][p.b + 3] == -1)
				{
					chk[p.a * 2][p.b + 3] = chk[p.a][p.b] + 1;
					q.add(new Pair(p.a * 2, p.b + 3));
				}
				if(p.a + 1 < 900 && chk[p.a + 1][p.b] == -1)
				{
					chk[p.a + 1][p.b] = chk[p.a][p.b] + 1;
					q.add(new Pair(p.a + 1, p.b));
				}
			}
		}
	}
}
class Pair{
	int a, b;
	Pair(int a, int b)
	{
		this.a = a;
		this.b = b;
	}
}