import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int K = sc.nextInt();
			int N = sc.nextInt();
			
			char[][] c = new char[K+1][N];
			
			for(int i = 0; i <= K; i++)
				c[i] = sc.next().toCharArray();
			
			boolean flag;
			int res = 0;
			for(int j = 0; j < N; j++)
			{
				char ch = c[0][j];
				flag = false;
				for(int i = 1; i <= K; i++)
					if(c[i][j] == ch) 
					{
						flag = true;
						break;
					}
				if(!flag) res++;
			}
			
			System.out.println("Data Set " + test_case + ":");
			System.out.println(res + "/" + N);
			System.out.println();
		}
	}
}