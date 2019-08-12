import java.math.BigInteger;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true)
		{			
			int b = sc.nextInt();
			if(b == 0) break;
			
			BigInteger bg = new BigInteger(sc.next(), b);
			int m = sc.nextInt();
			int m2 = Integer.parseInt(Integer.toString(m), b);
//			System.out.println(">> " + bg + " " + m2);
			bg = bg.mod(new BigInteger(Integer.toString(m2)));
			System.out.println(bg.toString(b));
		}
	}
}