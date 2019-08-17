import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] x = new int[M], y = new int[M];
		
		for(int i = 0; i < M; i++)
		{
			x[i] = sc.nextInt();
			y[i] = sc.nextInt();
		}
		
		Arrays.sort(x);
		Arrays.sort(y);
		
		int midX = x[M/2], midY = y[M/2], res = 0;
		
		for(int i = 0; i < M; i++)
		{
			if(x[i] > midX) res += x[i] - midX;
			else res += midX - x[i];
			if(y[i] > midY) res += y[i] - midY;
			else res += midY - y[i];
		}
		
		System.out.println(res);
	}
}