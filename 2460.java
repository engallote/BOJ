import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int in = 0, out = 0, now = 0, max = 0;
		
		for(int i = 0; i < 10; i++)
		{
			out = sc.nextInt();
			in = sc.nextInt();
			now += in;
			now -= out;
			if(max < now)
				max = now;
		}
		System.out.println(max);
	}
}