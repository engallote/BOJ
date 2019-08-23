import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = 0, B = 0;
		int[] a = new int[10], b = new int[10];
		
		for(int i = 0; i < 10; i++)
			a[i] = sc.nextInt();
		
		for(int i = 0; i < 10; i++)
			b[i] = sc.nextInt();
		
		for(int i = 0; i < 10; i++)
		{
			if(a[i] > b[i]) A++;
			else if(a[i] < b[i]) B++;
			else continue;
		}
		
		if(A == B)
			System.out.println("D");
		else if(A > B)
			System.out.println("A");
		else
			System.out.println("B");
	}
}