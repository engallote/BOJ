import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int len = N * 2 - 1;
		int l = len / 2, r = len / 2;
		for(int i = 0; i < N-1; i++)
		{
			for(int j = 0; j < len; j++)
			{
				if(j == l || j == r) System.out.print("*");
				else if(j > r) break;
				else System.out.print(" ");
			}
			l--;
			r++;
			System.out.println();
		}
		for(int i = 0; i < len; i++)
			System.out.print("*");
	}
}