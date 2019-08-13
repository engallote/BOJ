import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.nextLine();
		
		for(int i = 0; i < N; i++)
		{
			String[] str = sc.nextLine().split(" ");
			
			for(int j = 2; j < str.length; j++)
				System.out.print(str[j] + " ");
			System.out.println(str[0] + " " + str[1]);
		}
	}
}