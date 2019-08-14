import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = 0, B = 0;
		for(int i = 0; i < 3; i++)
		{
			if(i == 0)
				A += sc.nextInt() * 3;
			else if(i == 1)
				A += sc.nextInt() * 2;
			else A += sc.nextInt();
		}
		for(int i = 0; i < 3; i++)
		{
			if(i == 0)
				B += sc.nextInt() * 3;
			else if(i == 1)
				B += sc.nextInt() * 2;
			else B += sc.nextInt();
		}
		
		if(A > B)
			System.out.println("A");
		else if(A == B)
			System.out.println("T");
		else
			System.out.println("B");
	}
}