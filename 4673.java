import java.util.*;

public class Main {
	static boolean[] chk = new boolean[10001];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int i = 1; i <= 10000; i++)
			d(i);
		for(int i = 1; i <= 10000; i++)
			if(!chk[i])
				System.out.println(i);
	}

	private static void d(int num) {
		int res = num;
		while(num > 0)
		{
			res += num % 10;
			num /= 10;
		}
		if(res <= 10000)
			chk[res] = true;
	}
}