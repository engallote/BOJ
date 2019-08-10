import java.util.*;

public class Main {
	static int N, M;
	static int[] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[M];
		int[] arr2 = new int[10];
		
		for(int i = 0; i < M; i++) arr[i] = sc.nextInt();
		
		long res = solve(0, 0, arr2);
		System.out.println(res);
	}
	private static long solve(int idx, int num, int[] arr2) {
		if(idx == N)
		{
			for(int i = 0; i < M; i++)
				if(arr2[arr[i]] == 0) return 0;
			return 1;
		}
		long ret = 0;
		
		for(int i = 0; i < 10; i++)
		{
			arr2[i]++;
			ret += solve(idx + 1, i, arr2);
			arr2[i]--;
		}
		return ret;
	}
}