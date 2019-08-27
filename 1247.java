import java.math.BigInteger;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int t = 0; t < 3; t++)
		{
			int N = sc.nextInt();
			BigInteger bg = new BigInteger("0");
			
			for(int i = 0; i < N; i++)
				bg = bg.add(sc.nextBigInteger());
			
			if(bg.compareTo(new BigInteger("0")) == 0)
				System.out.println(0);
			else if(bg.compareTo(new BigInteger("0")) == -1)
				System.out.println("-");
			else
				System.out.println("+");
		}
	}
}