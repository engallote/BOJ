import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		for(int i = 0; i < N; i++)
		{
			String str = sc.next();
			long num = Long.parseLong(str, 2);
			
			System.out.println(num);
		}
	}
}