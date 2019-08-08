import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		boolean user = true, system = true;
		for(int i = 0; i < N; i++)
		{
			long a = sc.nextLong();
			long b = sc.nextLong();
			if(a != b) user = false;
		}
		for(int i = 0; i < M; i++)
		{
			long a = sc.nextLong();
			long b = sc.nextLong();
			if(a != b) system = false;
		}
		
		if(user && system)
			System.out.println("Accepted");
		else if(user && !system)
			System.out.println("Why Wrong!!!");
		else
			System.out.println("Wrong Answer");
	}
}