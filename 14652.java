import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int K = sc.nextInt();
		
		int div = K / M;
		int mod = K % M;
		System.out.println(div + " " + mod);
		
	}
}