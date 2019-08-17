import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		
		for(int t = 0; t < tc; t++)
		{
			int N = sc.nextInt();
			int[] arr = new int[N];
			
			for(int i = 0; i < N; i++)
				arr[i] = sc.nextInt();
			System.out.print("Case #" + (t+1) + ": ");
			if(N == 2)
			{
				if(arr[0] > arr[1])
					System.out.println("Alice");
				else
					System.out.println("Bob");
				continue;
			}
			int l = 0, r = N - 1;
			while(N >= 2)
			{
				while(l <= r)
				{
					arr[l] += arr[r];
					l++;
					r--;
				}
				N = r + 1;
				l = 0;
				r = N;
			}
			
			
			if(arr[0] > arr[1])
				System.out.println("Alice");
			else
				System.out.println("Bob");
		}
	}
}