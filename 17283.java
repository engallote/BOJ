import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int L = sc.nextInt();
		double R = sc.nextDouble();
		int sum = 0, cnt = 2;
		
		while(true)
		{
			int tmp = (int)(L * (R / 100));
			if(tmp <= 5) break;
			sum += (tmp * cnt);
			L = tmp;
			cnt *= 2;
		}
		
		System.out.println(sum);
	}
}