import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt();
		char[] ch = sc.next().toCharArray();
		
		int A = 0, B = 0;
		for(int i = 0; i < ch.length; i++)
		{
			if(ch[i] == 'A')
				A++;
			else
				B++;
		}
		
		if(A > B)
			System.out.println("A");
		else if(A < B)
			System.out.println("B");
		else
			System.out.println("Tie");
	}
}