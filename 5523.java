import java.util.*;

public class Main {
	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int a = 0, b = 0;
		for(int i = 0; i < N; i++)
		{
			int A = sc.nextInt();
			int B = sc.nextInt();
			if(A > B) a++;
			else if(A < B) b++;
		}
		System.out.println(a + " " + b);
	}
}