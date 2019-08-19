import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		char[] c = sc.next().toCharArray();
		long res = 0;
		for(int i = 0; i < N; i++)
		{
			if(c[i] >= '0' && c[i] <= '9')
			{
				int cnt = 0;
				StringBuilder tmp = new StringBuilder();
				for(int j = i; j < N; j++)
				{
					if(c[j] >= '0' && c[j] <= '9')
					{
						tmp.append(c[j]);
						cnt++;
					}
					else break;
				}
					
				if(cnt <= 6)
				{
					i += cnt - 1;
					res += Long.parseLong(tmp.toString());
				}
			}
		}
		System.out.println(res);
	}
}