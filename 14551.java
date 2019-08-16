import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		long M = sc.nextLong();
		
		long res = 1;
		
		for(int i = 0; i < N; i++)
		{
			long num = sc.nextLong();
			if(num == 0) num = 1;
			res = (res * num) % M;
		}
		
		System.out.println(res%M);
	}
}