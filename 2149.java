import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] key = sc.next().toCharArray();
		char[] c = sc.next().toCharArray();
		int N = key.length, M = c.length / key.length;
		char[][] arr = new char[M][N], arr2 = new char[M][N];
		int row = 0, col = 0;
		for(int i = 0; i < c.length; i++)
		{
			arr[row][col] = c[i];
			row++;
			if(row == M)
			{
				col++;
				row = 0;
			}
		}
		
		char[] sortKey = Arrays.copyOf(key, N);
		Arrays.sort(sortKey);
		
		for(int i = 0; i < N; i++)
		{
			for(int j = 0; j < N; j++)
				if(key[i] == sortKey[j])
				{
					sortKey[j] = '.';
					for(int k = 0; k < M; k++)
						arr2[k][i] = arr[k][j];
					break;
				}
		}
		
		for(int i = 0; i < M; i++)
		{
			for(int j = 0; j < N; j++)
				System.out.print(arr2[i][j]);
//			System.out.println();
		}
	}
}