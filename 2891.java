import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int S = sc.nextInt();
		int R = sc.nextInt();
		boolean[] visit = new boolean[N+2];
		int[] arr = new int[N+2];
		Arrays.fill(arr, 1);
		
		for(int i = 0; i < S; i++)
			arr[sc.nextInt()] = 0;
		
		for(int i = 0; i < R; i++)
			arr[sc.nextInt()]++;
		
		int cnt = 0;
		for(int i = 1; i <= N; i++)
		{
			if(arr[i] == 0)
			{
				if(arr[i-1] == 2 && !visit[i-1])
					visit[i-1] = true;
				else if(arr[i+1] == 2 && !visit[i+1])
					visit[i+1] = true;
				else
					cnt++;
			}
		}
		System.out.println(cnt);
	}
}