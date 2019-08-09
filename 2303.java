import java.util.*;

public class Main {
	static int tmp = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int max = 0, num = 0;
		for(int i = 1; i <= N; i++)
		{
			tmp = 0;
			int[] arr = new int[5];
			for(int j = 0; j < 5; j++)
				arr[j] = sc.nextInt();
			
			solve(0, 0, 0, arr);
//			System.out.println(tmp);
			if(tmp >= max)
			{
				max = tmp;
				num = i;
			}
		}
		System.out.println(num);
	}

	private static void solve(int idx, int sum, int cnt, int[] arr) {
		if(cnt == 3)
		{
			tmp = Math.max(tmp, sum % 10);
			return;
		}
		if(idx >= 5) return;
		solve(idx + 1, sum + arr[idx], cnt + 1, arr);
		solve(idx + 1, sum, cnt, arr);
	}
}