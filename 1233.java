import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int s1 = sc.nextInt();
		int s2 = sc.nextInt();
		int s3 = sc.nextInt();
		int[] arr = new int[101];
		for(int i = 1; i <= s1; i++)
			for(int j = 1; j <= s2; j++)
				for(int k = 1; k <= s3; k++)
				{
					int sum = i + j + k;
					arr[sum]++;
				}
		
		int max = 0, num = 0;
		for(int i = 3; i <= 100; i++)
			if(max < arr[i])
			{
				max = arr[i];
				num = i;
			}
		System.out.println(num);
	}
}