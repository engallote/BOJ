import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		long res = 0;
		for(int i = 1; i <= N; i++)
			if(N % i == 0) res+= i;
		
		res *= 5;
		res -= 24;
		System.out.println(res);
	}
}