import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		/*
		HashSet<Integer> hs = new HashSet<>();
		
		for(int i = 0; i < N; i++)
			hs.add(sc.nextInt());
		
		int M = sc.nextInt();
		
		for(int i = 0; i < M; i++)
		{
			int num = sc.nextInt();
			if(hs.contains(num))
				System.out.println(1);
			else
				System.out.println(0);
		}
		*/
		
		//ÀÌºÐÅ½»ö
		int[] arr = new int[N];
		
		for(int i = 0; i < N; i++)
			arr[i] = sc.nextInt();
		
		Arrays.sort(arr);
		
		int M = sc.nextInt();
		for(int i = 0; i < M; i++)
		{
			int num = sc.nextInt();
			int l = 0, h = N-1, mid = 0, res = 0;
			while(l <= h)
			{
				mid = (l + h) / 2;
				
				if(arr[mid] > num)
					h = mid - 1;
				else if(arr[mid] < num)
					l = mid + 1;
				else if(arr[mid] == num)
				{
					res = 1;
					break;
				}
			}
			System.out.println(res);
		}
	}
}