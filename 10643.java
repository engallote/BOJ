import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] pizza = new int[8];
		int res = 0;
		for(int i = 0; i < 8; i++)
			pizza[i] = sc.nextInt();
		
		for(int i = 0; i < 8; i++)
		{
			int start = i, cnt = 0, sum = 0;
			while(cnt < 4)
			{
				sum += pizza[start];
				cnt++;
				start++;
				if(start == 8) start = 0;
			}
			res = Math.max(res, sum);
		}
		System.out.println(res);
	}
}