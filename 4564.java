import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true)
		{
			int N = sc.nextInt();
			if(N == 0) break;
			
			while(true)
			{
				System.out.print(N + " ");
				if(N / 10 == 0) break;
				int num = 1;
				while(N > 0)
				{
					num *= N % 10;
					N /= 10;
				}
				N = num;
			}
			System.out.println();
		}
	}
}