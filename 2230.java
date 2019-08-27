import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] arr = new int[N];
		int min = Integer.MAX_VALUE;
		
		for(int i = 0; i < N; i++)
			arr[i] = sc.nextInt();
		
		Arrays.sort(arr);
		int st = 0;
		
		while(st < N-1)
		{
			for(int i = st + 1; i < N; i++)
			{
				if(arr[i] - arr[st] >= M)
				{
					if(min > arr[i] - arr[st])
						min = arr[i] - arr[st];
					break;//정렬했으니까 가장 가까운 수와 뺐으면 더 이상 반복하지 않고 탈출
				}
			}
			st++;
		}
		System.out.println(min);
	}
}