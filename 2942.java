import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);			
		int R = sc.nextInt();
		int G = sc.nextInt();
		int min = Math.min(R, G);
		for(int i = 1; i <= min; i++)
		{
			if(R % i == 0 && G % i == 0)
				System.out.println(i + " " + (R/i) + " " + (G/i));
			else continue;
		}
	}
}