import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[11];
		int sum = 0;
		Arrays.fill(arr, -1);
		
		for(int i = 0; i < N; i++)
		{
			int cow = sc.nextInt();
			int way = sc.nextInt();
			if(arr[cow] == -1)
				arr[cow] = way;
			else if(arr[cow] != way)
			{
				arr[cow] = way;
				sum++;
			}
		}
		
		System.out.println(sum);
	}
}