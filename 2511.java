import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] a = new int[10], b = new int[10];
		
		for(int i = 0; i < 10; i++)
			a[i] = sc.nextInt();
		
		for(int i = 0; i < 10; i++)
			b[i] = sc.nextInt();
		
		int A = 0, B = 0;
		String last = "D";
		for(int i = 0; i < 10; i++)
		{
			if(a[i] > b[i])
			{
				A += 3;
				last = "A";
			}
			else if(a[i] < b[i])
			{
				B += 3;
				last = "B";
			}
			else if(a[i] == b[i])
			{
				A += 1;
				B += 1;
			}
		}
		System.out.println(A + " " + B);
		if(A > B)
			System.out.println("A");
		else if(A < B)
			System.out.println("B");
		else
			System.out.println(last);
	}
}