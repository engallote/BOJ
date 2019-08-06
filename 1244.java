import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N+1];
		
		for(int i = 1; i <= N; i++)
			arr[i] = sc.nextInt();
		
		int M = sc.nextInt();
		
		for(int j = 0; j < M; j++)
		{
			int sex = sc.nextInt();
			int num = sc.nextInt();
			
			if(sex == 1)
			{
				for(int i = num; i <= N; i+=num)
					arr[i] = arr[i] == 1 ? 0 : 1;
			}
			else
			{
				int l = num, r = num;
				while(l > 0 && r <= N)
				{
					if(arr[l] == arr[r])
					{
						l--;
						r++;
					}
					else
						break;
				}
				
				for(int i = l+1; i < r; i++)
					arr[i] = arr[i] == 1 ? 0 : 1;
			}
			
//			for(int i = 1; i <= N; i++)
//				System.out.print(arr[i] + " ");
//			System.out.println();
		}
		
		int cnt = 0;
		for(int i = 1; i <= N; i++)
		{
			cnt++;
			System.out.print(arr[i] + " ");
			if(cnt== 20)
			{
				cnt = 0;
				System.out.println();
			}
		}
	}
}