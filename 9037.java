import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);		
		int tc = sc.nextInt();
		
		for(int test_case = 1; test_case <= tc; test_case++)
		{
			int N = sc.nextInt();
			int[] arr = new int[N];
			int[] arr2 = new int[N];
			int res = 0;
			for(int i = 0; i < N; i++)
			{
				arr[i] = sc.nextInt();
				if(arr[i] % 2 != 0) arr[i]++;
				arr2[i] = arr[i];
//				System.out.println(arr[i]);
			}
			Arrays.sort(arr2);
			if(arr2[0] == arr2[N-1])
				System.out.println(res);
			else
			{
				while(true)
				{
					arr2 = new int[N];
					int div = arr[0] / 2;
					arr[0] /= 2;
					arr[0] += arr[N-1] / 2;
					if(arr[0] % 2 != 0) arr[0]++;
//					System.out.print(arr[0] + " ");
					arr2[0] = arr[0];
					for(int i = 1; i < N; i++)
					{
						int tmp = arr[i] / 2;
						arr[i] /= 2;
						arr[i] += div;
						div = tmp;
						if(arr[i] % 2 != 0) arr[i]++;
						arr2[i] = arr[i];
//						System.out.print(arr[i] + " ");
					}
//					System.out.println();
					Arrays.sort(arr2);
					res++;
					if(arr2[0] == arr2[N-1]) break;
				}
				System.out.println(res);
			}
		}
	}
}