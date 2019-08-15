import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long A = sc.nextLong();
		long B = sc.nextLong();
		
		if(A > B)
		{
			long tmp = A;
			A = B;
			B = tmp;
		}
		A += 1;
		int cnt = 0;
		StringBuilder str = new StringBuilder();
		while(A < B)
		{
			cnt++;
			str.append(A + " ");
			A++;
		}
		System.out.println(cnt);
		System.out.println(str.toString());
	}
}