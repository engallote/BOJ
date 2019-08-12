import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true)
		{
			int N = sc.nextInt();
			
			if(N == 0) break;
			
			char[] c = sc.next().toCharArray();
			int len = c.length / N, idx = 0;
			char[][] arr = new char[len][N];
			int sw = 1;
			for(int i = 0; i < len; i++)
			{
				if(sw == 1)
				{
					for(int j = 0; j < N; j++)
					{
						arr[i][j] = c[idx];
						idx++;
					}
				}
				else
				{
					for(int j = N - 1; j >= 0; j--)
					{
						arr[i][j] = c[idx];
						idx++;
					}
				}
				sw *= -1;
			}

			for(int i = 0; i < N; i++)
				for(int j = 0; j < len; j++)
					System.out.print(arr[j][i]);
			System.out.println();
		}
	}
}