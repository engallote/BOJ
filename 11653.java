import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int cnt = 2;
		while(N > 1)
		{
			if(N % cnt == 0)
			{
				System.out.println(cnt);
				N /= cnt;
			}
			else
				cnt++;
		}
	}
}