import java.util.*;

public class Main {
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int K = sc.nextInt();
		double[] res = new double[N+1];
		
		for(int i = 0; i < M; i++)
		{
			for(int j = 0; j < N; j++)
			{
				int num = sc.nextInt();
				double tmp = sc.nextDouble();
				
				if(res[num] < tmp) res[num] = tmp;
			}
		}
		
		Arrays.sort(res);
		
		double sum = 0;
		
		for(int i = N; i > N - K; i--)
			sum += res[i];
		
		System.out.printf("%.1f",sum);
	}
}