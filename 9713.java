import java.util.*;

public class Main {
	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int sum = 0;
		for(int i = 0; i < N; i++)
		{
			sum = 0;
			int M = sc.nextInt();
			for(int j = 1; j <= M; j+=2)
				sum += j;
			System.out.println(sum);
		}
	}
}