import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true)
		{
			int N = sc.nextInt();
			if(N == 0) break;
			
			String[] arr = new String[N];
			
			for(int i = 0; i < N; i++)
				arr[i] = sc.next();
			int s = 0, e = ((N % 2 == 0) ? N / 2 : N / 2 + 1);
			while(e < N)
			{
				System.out.println(arr[s]);
				System.out.println(arr[e]);
				s++;
				e++;
			}
			if(N % 2 != 0 && s < N / 2 + 1) System.out.println(arr[s]);
//			System.out.println("=-======");
		}
	}
}