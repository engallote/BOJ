import java.util.*;

public class Main {
	static int N;
	static int[] chk;
	static boolean[][] prey;
	static boolean[] visit;
	static int[][] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N][3];
		chk = new int[N];
		visit = new boolean[N];
		prey = new boolean[N][N];
		
		Arrays.fill(chk, -1);
		
		for(int i = 0; i < N; i++)
		{
			int size = sc.nextInt();
			int speed = sc.nextInt();
			int intel = sc.nextInt();
			arr[i][0] = size;
			arr[i][1] = speed;
			arr[i][2] = intel;
		}

		for(int i = 0; i < N-1; i++)
		{
			for(int j = i+1; j < N; j++)
			{
				if(i != j)
				{
					if(arr[i][0] >= arr[j][0] && arr[i][1] >= arr[j][1] && arr[i][2] >= arr[j][2])
					{
//						System.out.println(i+"∞° "+j+"∏¶ ∏‘¿Ω");
						prey[i][j] = true;
					}
					if(arr[i][0] == arr[j][0] && arr[i][1] == arr[j][1] && arr[i][2] == arr[j][2])
						continue;
					if(arr[i][0] <= arr[j][0] && arr[i][1] <= arr[j][1] && arr[i][2] <= arr[j][2])
					{
//						System.out.println(j+"∞° "+i+"∏¶ ∏‘¿Ω");
						prey[j][i] = true;
					}
				}
			}
		}
		int res = 0;
		for(int i = 0; i < N; i++)
		{
			Arrays.fill(visit, false);
			if(dfs(i))
				res++;
		}
		for(int i = 0; i < N; i++)
		{
			Arrays.fill(visit, false);
			if(dfs(i))
				res++;
		}
		
		System.out.println(N-res);
	}
	
	private static boolean dfs(int idx) {
		if(visit[idx]) return false;
		visit[idx] = true;
		
		for(int i = 0; i < N; i++)
			if(prey[idx][i])
			{
				if(chk[i] == -1 || dfs(chk[i]))
				{
					chk[i] = idx;
					return true;
				}
			}
		return false;
	}
}