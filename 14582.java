import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] ze = new int[9], st = new int[9];
		
		for(int i = 0; i < 9; i++)
			ze[i] = sc.nextInt();
		for(int i = 0; i < 9; i++)
			st[i] = sc.nextInt();
		
		boolean win = false;
		int z = 0, s = 0;
		for(int i = 0; i < 9; i++)
		{
			z += ze[i];
			if(z > s) win = true;
			s += st[i];
		}
		
		if(z > s)
			System.out.println("No");
		else
			System.out.println(win ? "Yes" : "No");
	}
}