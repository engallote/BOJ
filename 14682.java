import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int sum = N;
		
		for(int i = 1; i <= K; i++)
			sum += N * (int)Math.pow(10, i);
		
		System.out.println(sum);
	}
}