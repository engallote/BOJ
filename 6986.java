import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		double[] arr = new double[N];
		
		for(int i = 0; i < N; i++)
			arr[i] = sc.nextDouble();
		
		Arrays.sort(arr);
		
		/////////// Àý»çÆò±Õ
		double sum = 0;
		int cnt = 0;
		for(int i = K; i < N-K; i++)
		{
			sum += arr[i];
			cnt++;
		}
		
		System.out.printf("%.2f", sum / cnt);
		System.out.println();
		/////////// º¸Á¤Æò±Õ
		for(int i = 0, j = N-1; i < K && j >= N-K; i++, j--)
		{
			arr[i] = arr[K];
			arr[j] = arr[N-K-1];
		}
		
		sum = 0;
		for(int i = 0; i < N; i++)
			sum += arr[i];
		
		System.out.printf("%.2f", sum / N);
	}
}