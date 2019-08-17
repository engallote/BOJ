import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		for(int i = 1; i <= N; i++)
		{
			String s = sc.next();
			String p = sc.next();
			int cnt = 0;
			while(s.contains(p))
			{
				s = s.replaceFirst(p, "");
				cnt++;
			}
			
			cnt += s.length();
			System.out.println(cnt);
		}
	}
}