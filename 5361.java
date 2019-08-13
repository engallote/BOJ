import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		double[] arr = {350.34, 230.90, 190.55, 125.30, 180.90};
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int A = sc.nextInt();
			int B = sc.nextInt();
			int C = sc.nextInt();
			int D = sc.nextInt();
			int E = sc.nextInt();
			
			double sum = A * arr[0] + B * arr[1] + C * arr[2] + D * arr[3] + E * arr[4];
			System.out.println(String.format("$%.2f", sum));
		}
	}
}