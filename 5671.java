import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[5001];
		int[] num = new int[10];
		for(int i = 1; i <= 5000; i++)
		{
			int n = i;
			int max = 0;
			Arrays.fill(num, 0);
			while(n > 0)
			{
				num[n % 10]++;
				max = Math.max(max, num[n%10]);
				n /= 10;
			}
			if(max > 1) arr[i] = arr[i-1];
			else arr[i] = arr[i-1] + 1;
		}
		while(sc.hasNext())
		{
			int a = sc.nextInt();
			int b = sc.nextInt();
			System.out.println(arr[b] - arr[a-1]);
		}
	}
}