import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int res = 0;
		char pre = '.';
		for(int i = 1; i <= N; i++)
		{
			char c = sc.next().charAt(0);
			if(pre == c) continue;
			pre = c;
			res++;
		}
		res++;
		System.out.println(res);
	}
}