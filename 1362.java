import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = 1;
		while(true)
		{
			int N = sc.nextInt();
			int M = sc.nextInt();
			if(N == 0 && M == 0) break;
			boolean flag = true;
			while(true)
			{
				char c = sc.next().charAt(0);
				int K = sc.nextInt();
				
				if(c == '#' && K == 0) break;
				if(c == 'E')
				{
					M -= K;
					if(M <= 0) flag = false;
				}
				else M += K;
			}
			System.out.print(tc + " ");
			if(flag && M > N / 2 && M <= N * 2) System.out.println(":-)");
			else if(flag) System.out.println(":-(");
			else System.out.println("RIP");
			tc++;
		}
	}
}