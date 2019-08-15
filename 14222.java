import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int[] arr = new int[N], num = new int[51];
		
		for(int i = 0; i < N; i++)
		{
			arr[i] = sc.nextInt();
			num[arr[i]]++;
		}
		boolean flag = true;
		for(int i = 1; i <= N; i++)
		{
			if(num[i] == 0)
			{
				flag = false;
				break;
			}
			if(num[i] > 1 && i + K <= N)
			{
				while(num[i] > 1)
				{
					num[i]--;
					num[i+K]++;
				}
			}
		}
		
		System.out.println(flag ? 1 : 0);
	}
}