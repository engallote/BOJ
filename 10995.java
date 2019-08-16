import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int sw = 1;
		for(int i = 0; i < N; i++)
		{
			if(sw == 1)
				for(int j = 0; j < N; j++)
				{
					if(j == N - 1) System.out.print("*");
					else System.out.print("* ");
				}
			else
				for(int j = 0; j < N; j++)
					System.out.print(" *");
			System.out.println();
			sw *= -1;
		}
	}
}