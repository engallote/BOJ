import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int L = sc.nextInt();
		int R = sc.nextInt();
		int A = sc.nextInt();
		
		while(L < R && A > 0)
		{
			L++;
			A--;
		}
		while(L > R && A > 0)
		{
			R++;
			A--;
		}
		
		if(L == R)
		{
			while(A >= 2)
			{
				L++;
				R++;
				A -= 2;
			}
			System.out.println(L+R);
		}
		else
			System.out.println(Math.min(L, R)+Math.min(L, R));
	}
}