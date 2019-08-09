import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();
		int q = sc.nextInt();
		int l = sc.nextInt();
		int b = sc.nextInt();
		int n = sc.nextInt();
		int p = sc.nextInt();
		
		if(k > 1)
			System.out.print(-(k - 1) + " ");
		else if(k == 1)
			System.out.print(0 + " ");
		else
			System.out.print(1 + " ");
		
		if(q > 1)
			System.out.print(-(q - 1) + " ");
		else if(q == 1)
			System.out.print(0 + " ");
		else
			System.out.print(1 + " ");
		
		if(l > 2)
			System.out.print(-(l - 2) + " ");
		else if(l == 2)
			System.out.print(0 + " ");
		else if(l == 1)
			System.out.print(1 + " ");
		else
			System.out.print(2 + " ");
		
		if(b > 2)
			System.out.print(-(b - 2) + " ");
		else if(b == 2)
			System.out.print(0 + " ");
		else if(b == 1)
			System.out.print(1 + " ");
		else
			System.out.print(2 + " ");
		
		if(n > 2)
			System.out.print(-(n - 2) + " ");
		else if(n == 2)
			System.out.print(0 + " ");
		else if(n == 1)
			System.out.print(1 + " ");
		else
			System.out.print(2 + " ");
		
		if(p > 8)
			System.out.print(-(p - 8));
		else if(p == 8)
			System.out.print(0 + " ");
		else if(p > 0 && p < 8)
			System.out.print(8 - p);
		else
			System.out.print(8);
	}
}