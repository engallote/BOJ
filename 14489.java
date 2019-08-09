import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		
		if(A + B >= 2 * C)
		{
			int res = (A + B) - (2 * C);
			System.out.println(res);
		}
		else
			System.out.println(A+B);
	} 
}