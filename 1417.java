import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = 0;
		int[] arr = new int[N+1];
		
		for(int i = 1; i <= N; i++)
		{
			arr[i] = sc.nextInt();
			if(i == 1)
				M = arr[i];
		}
		if(N == 1)
		{
			System.out.println(0);
			return;
		}
		arr[1] = 0;
		int cnt = 0;
		while(true)
		{
			Arrays.sort(arr);
			boolean flag = false;
			for(int i = N; i >= 2; i--)
			{
				if(M <= arr[i])
				{
					arr[i]--;
					M++;
					cnt++;
					break;
				}
				else
				{
					flag = true;
					break;
				}
			}
			if(flag) break;
		}
		System.out.println(cnt);
	}
}