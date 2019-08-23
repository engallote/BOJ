import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		for(int i = 0; i < N; i++)
			arr[i] = sc.nextInt();
		
		long res = 0;
		for(int i = 0; i < N; i++)
		{
			long cnt = 0;
			for(int j = i+1; j < N; j++)
			{
				if(arr[j] < arr[i]) cnt++;
				else break;
			}
			res += cnt;
		}
		
		System.out.println(res);
	}
}