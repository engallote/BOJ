import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int t = 0; t < T; t++)
		{
			int N = sc.nextInt();
			if((N&(-N)) == N) System.out.println(1);
			else System.out.println(0);
		}
	}
}