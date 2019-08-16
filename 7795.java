import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		
		for(int t = 0; t < tc; t++)
		{
			int N = sc.nextInt();
			int M = sc.nextInt();
			int[] a = new int[N], b = new int[M];
			for(int i = 0; i < N; i++)
				a[i] = sc.nextInt();
			for(int j = 0; j < M; j++)
				b[j] = sc.nextInt();
			
			Arrays.sort(a);
			Arrays.sort(b);
			
			int res = 0;
			for(int i = 0; i < N; i++)
			{
				for(int j = 0; j < M; j++)
				{
					if(a[i] > b[j]) res++;
					else break;
				}
			}
			System.out.println(res);
		}
	}
}