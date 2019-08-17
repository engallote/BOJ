import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[5];
		int sum = 0;
		for(int i = 0; i < N; i++)
		{
			sum = 0;
			for(int j = 0; j < 5; j++)
			{
				arr[j] = sc.nextInt();
				sum += arr[j];
			}
			
			Arrays.sort(arr);
			
			if(Math.abs(arr[3] - arr[1]) >= 4)
				System.out.println("KIN");
			else
				System.out.println(sum-arr[0]-arr[4]);
		}
	}
}