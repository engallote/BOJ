import java.util.*;

public class Main {
	static int N, M, X, Y;
	static int[] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			N = sc.nextInt();
			arr = new int[N];
			M = sc.nextInt();
			X = 0;
			Y = 0;
			
			for(int i = 0; i < M; i++)
			{
				X *= 10;
				X += sc.nextInt();
			}
			for(int i = 0; i < M; i++)
			{
				Y *= 10;
				Y += sc.nextInt();
			}
			
			for(int i = 0; i < N; i++)
				arr[i] = sc.nextInt();
			
			int idx = 0, ret = 0, res = 0, cnt = 0;
			while(idx < N)
			{
				ret = 0;
				cnt = 0;
				for(int i = idx; i < N; i++)
				{
					ret *= 10;
					ret += arr[i];
					cnt++;
					if(cnt == M) break;
				}
				if(cnt < M)
				{
					for(int i = 0; i < idx; i++)
					{
						ret *= 10;
						ret += arr[i];
						cnt++;
						if(cnt == M) break;
					}
				}
				if(ret >= X && ret <= Y) res++;
//				System.out.println(ret);
				idx++;
			}
			System.out.println(res);
		}
	}
}