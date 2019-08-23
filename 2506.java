import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int res = 0;
		int cnt = 1;
		for(int i = 0; i < N; i++)
		{
			int n = sc.nextInt();
			if(n == 1)
			{
				n *= cnt;
				res += n;
				cnt++;
			}
			else
				cnt = 1;
		}
		
		System.out.println(res);
	}
}