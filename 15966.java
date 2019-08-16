import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		int[] num = new int[1000001];
		int res = 0;
		for(int i = 0; i < N; i++)
		{
			arr[i] = sc.nextInt();
			num[arr[i]] = 1;
			num[arr[i]] += num[arr[i]-1];
			res = Math.max(num[arr[i]], res);
		}
		
		System.out.println(res);
	}
}