import java.math.BigInteger;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BigInteger N = new BigInteger(sc.next());
		BigInteger bg = BigInteger.ONE;
		
		if(N.compareTo(BigInteger.ONE) == 0)
		{
			System.out.println(1);
			return;
		}
		boolean flag = false;
		while(bg.compareTo(N) <= 0)
		{
			if(bg.compareTo(N) == 0)
			{
				flag = true;
				break;
			}
			bg = bg.multiply(new BigInteger("2"));
		}
		if(flag)
			System.out.println(1);
		else
			System.out.println(0);
	}
}