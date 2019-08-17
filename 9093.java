import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.nextLine();
		for(int i = 0; i < N; i++)
		{
			String[] str = sc.nextLine().split(" ");
			StringBuilder sb;
			for(int j = 0; j < str.length; j++)
			{
				 sb = new StringBuilder();
				 sb.append(str[j]);
				 System.out.print(sb.reverse() + " ");
			}
			System.out.println();
		}
	}
}