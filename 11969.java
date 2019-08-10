import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int Q = sc.nextInt();
		int[] h = new int[N+1], g = new int[N+1], j = new int[N+1];
		
		for(int i = 1; i <= N; i++)
		{
			int num = sc.nextInt();
			h[i] += h[i-1];
			g[i] += g[i-1];
			j[i] += j[i-1];
			if(num == 1) h[i]++;
			else if(num == 2) g[i]++;
			else j[i]++;
		}
		
		for(int i = 0; i < Q; i++)
		{
			int s = sc.nextInt();
			int e = sc.nextInt();
			
			System.out.println((h[e]-h[s-1]) + " " + (g[e]-g[s-1]) + " " + (j[e]-j[s-1]));
		}
	}
}