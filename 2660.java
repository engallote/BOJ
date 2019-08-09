import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int INF = 1000000, cnt = 0;
		int[] res = new int[N+1];
		int[][] arr = new int[N+1][N+1];
		boolean[] visit = new boolean[N+1];
		for(int i = 1; i <= N; i++)
		{
			Arrays.fill(arr[i], INF);
			arr[i][i] = 0;
		}
		while(true)
		{
			int a = sc.nextInt();
			int b = sc.nextInt();
			if(a == -1 && b == -1) break;
			arr[a][b] = arr[b][a] = 1;
		}
		
		for(int k = 1; k <= N; k++)
			for(int i = 1; i <= N; i++)
				for(int j = 1; j <= N; j++)
					if(arr[i][k] + arr[k][j] < arr[i][j])
						arr[i][j] = arr[i][k] + arr[k][j];
		
//		for(int i = 1; i <= N; i++)
//		{
//			for(int j = 1; j <= N; j++)
//				System.out.print(arr[i][j] + " ");
//			System.out.println();
//		}
		int min = INF;
		for(int i = 1; i <= N; i++)
		{
			int max = 0;
			for(int j = 1; j <= N; j++)
				max = Math.max(max, arr[i][j]);
			res[i] = max;
			if(min > max)
				min = max;
		}
		Vector<Integer> v = new Vector<>();
		for(int i = 1; i <= N; i++)
			if(res[i] == min)
			{
				cnt++;
				v.add(i);
			}
		
		System.out.println(min + " " + cnt);
		for(int i : v)
			System.out.print(i + " ");
	}
}