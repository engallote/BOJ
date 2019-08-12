import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = sc.nextInt();
			int[] arr = new int[1001];
			int max = 0, number = 0;
			for(int i = 0; i < N; i++)
			{
				int num = sc.nextInt();
				arr[num]++;
				if(max < arr[num])
				{
					max = arr[num];
					number = num;
				}
				else if(max == arr[num] && number > num) number = num;
			}
			
			System.out.println(number);
		}
	}
}