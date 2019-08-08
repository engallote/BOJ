import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = 1;
		while(true)
		{
			int num = sc.nextInt();
			if(num == 0) break;
			int m = 0;
			num *= 3;
			if(num % 2 == 0)
				num /= 2;
			else
			{
				m = 1;
				num = (num + 1) / 2;
			}
			
			num *= 3;
			num /= 9;
			
//			if(num % 2 == 0)
//				num *= 2;
//			else
//				num = num * 2 + 1;
			System.out.println(t + ". " + (m == 0 ? "even " : "odd ") + num);	
			t++;
		}
	}
}