import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int K = sc.nextInt();
			HashSet<Integer> hs = new HashSet<>();
			for(int i = 0; i < K; i++)
				hs.add(sc.nextInt());
			
			int N = sc.nextInt(), res = 0, cnt = 0;
			int minH = Integer.MAX_VALUE, minD = Integer.MAX_VALUE;
			for(int i = 0; i < N; i++)
			{
				int num = sc.nextInt();
				int h = sc.nextInt();
				int m = sc.nextInt();
				if(h == -1) continue;
				if(hs.contains(num))
				{
					if(h <= 6)
					{
						if(h < 6) cnt++;
						else if(h == 6 && m == 0) cnt++;
					}
					if(minH > h)
					{
						res = num;
						minH = h;
						minD = m;
					}
					else if(minH == h && minD > m)
					{
						res = num;
						minD = m;
					}
				}
			}
			System.out.println(res + " " + cnt);
		}
	}
}