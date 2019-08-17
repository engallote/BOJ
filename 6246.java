import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int Q = sc.nextInt();
		int[] arr = new int[N+1];
		int res = N;
		
		for(int i = 0; i < Q; i++)
		{
			int L = sc.nextInt();
			int I = sc.nextInt();
			
			for(int j = L; j <= N; j+=I)
				if(arr[j] == 0)
				{
					arr[j] = 1;
					res--;
				}
		}
		System.out.println(res);
	}
}