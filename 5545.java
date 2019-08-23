import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int A = sc.nextInt();//도우 가격
		int B = sc.nextInt();//토핑 가격
		int C = sc.nextInt();//도우 열량
		int[] arr = new int[N];
		int max = C / A;		
		
		for(int i = 0; i < N; i++)
			arr[i] = sc.nextInt();
		
		Arrays.sort(arr);
		
		int sum = 0, cnt = 0;
		for(int i = N - 1; i >= 0; i--)
		{
			sum += arr[i];
			++cnt;
			
			int result = (C + sum) / (A + cnt * B);
			if(result < max)
				break;
			max = result;
		}
		
		System.out.println(max);
	}
}