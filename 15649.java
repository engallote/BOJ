import java.util.*;

public class Main {
	static int N, M;
	static int[] visit;
	static boolean[] chk;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		visit = new int[N+1];
		chk = new boolean[N+1];
		solve(1);
	}
	private static void solve(int len) {
		if(len == M + 1)
		{
			for(int i = 1; i <= M; i++)
				if(visit[i] > 0)
					System.out.print(visit[i] + " ");
			System.out.println();
			return;
		}
		
		for(int i = 1; i <= N; i++)
		{
			if(!chk[i])
			{
				chk[i] = true;
				visit[len] = i;
				solve(len+1);
				visit[len] = 0;
				chk[i] = false;
			}
		}
	}
}