import java.util.*;

public class Main {
	static long[] sum = new long[3000001];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.nextLine();
		for(int i = 0; i < N; i++)
		{
			String str = sc.nextLine();
			
			if(str.contains("Simon says"))
			{
				str = str.replaceFirst("Simon says", "");
				System.out.println(str);
			}
		}
	}
}