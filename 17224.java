import java.util.*;

public class Main {
	static int N, L, K;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		L = sc.nextInt();
		K = sc.nextInt();
		
		int e = 0, h = 0;
		for(int i = 0; i < N; i++)
		{
			int easy = sc.nextInt();
			int hard = sc.nextInt();
			if(hard <= L) h++;
			else if(hard > L && easy <= L) e++;
		}
		
		if(h >= K) h = K;
		if(h + e > K) e = K - h;
		
		int res = (h * 140) + (e * 100);
		System.out.println(res);
	}
}