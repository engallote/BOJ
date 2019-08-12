import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int g = 0, s = 0;
			for(int i = 1; i <= 6; i++)
			{
				if(i == 1) g += sc.nextInt();
				else if(i == 2) g += (sc.nextInt() * 2);
				else if(i <= 4) g += (sc.nextInt() * 3);
				else if(i == 5) g += (sc.nextInt() * 4);
				else g += (sc.nextInt() * 10);
			}
			
			for(int i = 1; i <= 7; i++)
			{
				if(i == 1) s += sc.nextInt();
				else if(i <= 4) s += (sc.nextInt() * 2);
				else if(i == 5) s += (sc.nextInt() * 3);
				else if(i == 6) s += (sc.nextInt() * 5);
				else s += (sc.nextInt() * 10);
			}
			System.out.print("Battle " + test_case + ": ");
			if(g > s) System.out.println("Good triumphs over Evil");
			else if(g < s) System.out.println("Evil eradicates all trace of Good");
			else System.out.println("No victor on this battle field");
		}
	}
}