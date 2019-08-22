import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		StringBuilder str = new StringBuilder();
		
		for(int i = 0; i < N; i++)
		{
			str.append(N);
			if(str.toString().length() >= M) break;
		}
		
		String ans = str.toString();
		if(ans.length() > M)
			ans = ans.substring(0, M);
		System.out.println(ans);
	}
}