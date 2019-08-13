import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int a = 0, b = 0;
		for(int i = 0; i < N; i++)
			a += Math.abs(sc.nextInt());
		for(int i = 0; i < N; i++)
			b += -Math.abs(sc.nextInt());
		
		System.out.println(a-b);
	}
}