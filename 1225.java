import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] a = sc.next().toCharArray();
		char[] b = sc.next().toCharArray();
		
		long A = 0, B = 0;
		for(int i = 0; i < a.length; i++)
			A += a[i] - '0';
		
		for(int i = 0; i < b.length; i++)
			B += b[i] - '0';
		
		System.out.println(A*B);
	}
}