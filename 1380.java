import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = 1;
		while(true)
		{
			int N = sc.nextInt();
			sc.nextLine();
			if(N == 0) break;
			
			String[] name = new String[N];
			for(int i = 0; i < N; i++)
				name[i] = sc.nextLine();
			
			int[] arr = new int[N+1];
			
			for(int i = 0; i < 2 * N - 1; i++)
			{
				int a = sc.nextInt();
				char c = sc.next().charAt(0);
				arr[a] = arr[a] == 0 ? 1 : 0;
			}
			
			for(int i = 1; i <= N; i++)
				if(arr[i] == 1)
				{
					System.out.println(tc + " " + name[i-1]);
					break;
				}
			tc++;
		}
	}
}