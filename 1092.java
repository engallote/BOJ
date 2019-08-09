import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		int cnt = 0;
		for(int i = 0; i < N; i++)
			arr[i] = sc.nextInt();	
		Arrays.sort(arr);
		
		int M = sc.nextInt();
		int[] box = new int[M];
		
		for(int i = 0; i < M; i++)
			box[i] = sc.nextInt();
		
		Arrays.sort(box);
		int T = M, count = 0;
		while(T > 0)
		{
			count = 0;
			for(int i = M - 1, j = N - 1; i >= 0 && j >= 0; i--)
			{
				if(box[i] == -1) continue;
				if(box[i] <= arr[j])
				{
//					System.out.println(box[i] + " " + arr[j]);
					box[i] = -1;
					j--;
					count++;
				}	
			}
			if(count == 0)
			{
				cnt = -1;
				break;
			}
			T -= count;
			cnt++;
		}
		
		System.out.println(cnt);
	}
}
