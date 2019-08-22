import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextLong())
		{
			long x = sc.nextLong();//구멍 너비
			int N = sc.nextInt();
			if(N == 0 || x > 20)
			{
				System.out.println("danger");
				continue;
			}
			x *= 10000000;
			long[] arr = new long[N];
			for(int i = 0; i < N; i++)
				arr[i] = sc.nextLong();
			
			//10cm = 100,000,000 나노미터
			Arrays.sort(arr);
			
			int l = 0, h = N - 1;
			long sum = 0;
			while(l < h)
			{
				sum = arr[l] + arr[h];
				if(sum == x) break;
				else if(sum > x) h--;
				else l++;
			}
			
			if(sum == x)
				System.out.println("yes " + arr[l] + " " + arr[h]);
			else
				System.out.println("danger");
		}
	}
}