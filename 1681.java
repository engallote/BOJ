import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int L = sc.nextInt();
		int cnt = 0, res = 0;
		for(int i = 1; ; i++)
		{
			String s = Integer.toString(i);
			if(s.contains(L+"")) continue;
			cnt++;
			if(cnt == N)
			{
				res = i;
				break;
			}
		}
		System.out.println(res);
    }
}