import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		long sum = 0;
		for(int i = 0; i < N; i++)
		{
			arr[i] = sc.nextInt();
			sum += arr[i];
		}
		
		Arrays.sort(arr);
		
		long min = Long.MAX_VALUE, num = arr[(N-1)/2], num2 = sum / N;
		
		while(true)
		{
			long tmp = 0;
			for(int i = 0; i < N; i++)
				tmp += Math.abs(num2 - arr[i]) * Math.abs(num2 - arr[i]);
			if(min > tmp)
			{
				min = tmp;
				num2++;
			}
			else
			{
				num2--;
				break;
			}
		}
		System.out.println(num + " " + num2);
	}
}