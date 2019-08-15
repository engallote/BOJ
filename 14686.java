import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] sw = new int[N], sp = new int[N];
		for(int i = 0; i < N; i++)
		{
			sw[i] = sc.nextInt();
			if(i > 0) sw[i] += sw[i-1]; 
		}
		for(int i = 0; i < N; i++)
		{
			sp[i] = sc.nextInt();
			if(i > 0) sp[i] += sp[i-1]; 
		}
		int K = 0;
		for(int i = 0; i < N; i++)
		{
			if(sw[i] == sp[i]) K = i + 1;
		}
		System.out.println(K);
	}
}