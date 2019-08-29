import java.util.*;

public class Main {
	static int N, M;
	static char[][] arr1, arr2;
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr1 = new char[N][M];
		arr2 = new char[N][M];
		
		for(int i = 0; i < N; i++)
			arr1[i] = sc.next().toCharArray();
		
		for(int i = 0; i < N; i++)
			arr2[i] = sc.next().toCharArray();
		
		if(check())
		{
			System.out.println(0);
			return;
		}
		int cnt = 0;
		for(int i = 0; i < N-2; i++)
		{
			for(int j = 0; j < M - 2; j++)
				if(arr1[i][j] != arr2[i][j])
				{
					for(int k = i; k < i+3; k++)
						for(int l = j; l < j+3; l++)
							arr1[k][l] = arr1[k][l] == '1' ? '0' : '1';
					cnt++;
				}
			if(check())
			{
				System.out.println(cnt);
				return;
			}
		}
		System.out.println(-1);
	}

	private static boolean check() {
		for(int i = 0; i < N; i++)
			for(int j = 0; j < M; j++)
				if(arr1[i][j] != arr2[i][j])
					return false;
		return true;
	}
}