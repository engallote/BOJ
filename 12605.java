import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.nextLine();
		for(int i = 0; i < N; i++)
		{
			String[] str = sc.nextLine().split(" ");
			System.out.print("Case #" + (i+1) + ": ");
			for(int j = str.length - 1; j >= 0; j--)
				System.out.print(str[j] + " ");
			System.out.println();
		}
	}
}