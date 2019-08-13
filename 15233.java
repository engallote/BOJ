import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int K = sc.nextInt();
		int a = 0, b = 0;
		HashSet<String> A = new HashSet<>(), B = new HashSet<>();
		for(int i = 0; i < N; i++)
		{
			String name = sc.next();
			A.add(name);
		}
		for(int i = 0; i < M; i++)
		{
			String name = sc.next();
			B.add(name);
		}
		
		for(int i = 0; i < K; i++)
		{
			String name = sc.next();
			if(A.contains(name)) a++;
			else b++;
		}
		
		if(a > b) System.out.println("A");
		else if(a < b) System.out.println("B");
		else System.out.println("TIE");
	}
}