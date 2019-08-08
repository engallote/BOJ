import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		long res = 0, max = 0;
		for(int i = 0; i < N; i++)
		{
			long num = sc.nextInt();
			max = Math.max(max, num);
		}
		res = max;
		max = 0;
		for(int i = 0; i < M; i++)
		{
			long num = sc.nextInt();
			max = Math.max(max, num);
		}
		res += max;
		System.out.println(res);
	}
}