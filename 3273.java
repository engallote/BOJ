import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N], idx = new int[1000001];
		boolean[] num = new boolean[1000001]; 
		for(int i = 0; i < N; i++)
		{
			arr[i] = sc.nextInt();
			num[arr[i]] = true;
			idx[arr[i]] = i;
		}
		int X = sc.nextInt();
		int res = 0;
		for(int i = 0; i < N; i++)
		{
			int sub = Math.abs(X - arr[i]);
			if(sub > 1000000 || arr[i] == sub || arr[i] > X) continue;
			if(num[sub] && idx[sub] > i)
			{
				res++;
			}
		}
		System.out.println(res);
	}
}