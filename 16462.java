import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		double sum = 0;
		for(int i = 0; i < N; i++)
		{
			char[] c = sc.next().toCharArray();
			
			for(int j = 0; j < c.length; j++)
				if(c[j] == '0' || c[j] == '6') c[j] = '9';
			
			int num = Integer.parseInt(new String(c));
			sum += (num >= 100) ? 100 : num;
		}
		System.out.println((int)Math.round(sum/N));
	}
}