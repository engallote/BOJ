import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		if((M % 2 == 0 && N % 3 == 0) || M % 3 == 0 || (M % 2 != 0 && M % 3 != 0 && N % 3 == 0)) 
			System.out.println("YES");
		else System.out.println("NO");
	}
}