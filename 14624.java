import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		if(N % 2 == 0) System.out.println("I LOVE CBNU");
		else
		{
			for(int i = 0; i < N; i++)
				System.out.print("*");
			System.out.println();
			int mid = N / 2;
			int l = mid, r = mid;
			while(l >= 0 && r < N)
			{
				for(int i = 0; i < N; i++)
				{
					if(i ==  l || i == r)
						System.out.print("*");
					else if(i < r) System.out.print(" ");
				}
				l--;
				r++;
				if(l < 0) break;
				System.out.println();
			}
		}
	}
}