import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		double res = 0;
		double[] arr = new double[N + 1];
		arr[0] = 1;
		
		for(int i = 1; i <= N; i++)
		{
			arr[i] = sc.nextDouble();
			res = Math.max(res, arr[i]);
		}
		
		for(int i = 1; i < N; i++)
		{
			double mul = 1;
			for(int j = i; j <= N; j++)
			{
				mul *= arr[j];
				if(res < mul) res = mul;
			}
		}
		
		System.out.println(String.format("%.3f", res));
	}
}