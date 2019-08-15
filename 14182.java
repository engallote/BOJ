import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true)
		{
			int N = sc.nextInt();
			if(N == 0) break;
			
			if(N <= 1000000) System.out.println(N);
			else if(N <= 5000000) System.out.println((int)(N * 0.9));
			else System.out.println((int)(N * 0.8));
		}
	}
}