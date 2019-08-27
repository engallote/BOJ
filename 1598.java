import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int start = 4, count = 1;
		int c1 = 0, c2 = 0, l1 = 0, l2 = 0;
		while(true)
		{
			int tmp = start * count;
			if(tmp >= N)
				break;
			count++;
		}
		c1 = count;
		count = 1;
		while(true)
		{
			int tmp = start * count;
			if(tmp >= M)
				break;
			count++;
		}
		c2 = count;
		count = 0;
		while(true)
		{
			int tmp = (c1 * 4) - count;
			if(tmp == N)
				break;
			count++;
		}
		l1 = count;
		count = 0;
		while(true)
		{
			int tmp = (c2 * 4) - count;
			if(tmp == M)
				break;
			count++;
		}
		l2 = count;
		int res = Math.abs(c2 - c1) + Math.abs(l2 - l1);
		System.out.println(res);
	}
}