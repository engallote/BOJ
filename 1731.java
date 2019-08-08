import java.util.*;

public class Main {
	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int[] arr = new int[N];
		
		for(int i = 0; i < N; i++)
			arr[i] = sc.nextInt();
		
		int ret = isPlus(arr);
		if(ret != Integer.MAX_VALUE)
			System.out.println(arr[N-1] + ret);
		else
		{
			ret = isMul(arr);
			System.out.println(arr[N-1]*ret);
		}
	}

	private static int isMul(int[] arr) {
		int pre = arr[1] / arr[0];
		for(int i = 1; i < N; i++)
		{
			if(arr[i] / arr[i-1] == pre) continue;
			else return Integer.MAX_VALUE;
		}
		return pre;
	}

	private static int isPlus(int[] arr) {
		int pre = arr[1] - arr[0];
		for(int i = 1; i < N; i++)
		{
			if(arr[i] - arr[i-1] == pre) continue;
			else return Integer.MAX_VALUE;
		}
		return pre;
	}
}