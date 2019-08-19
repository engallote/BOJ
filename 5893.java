import java.math.BigInteger;
import java.util.*;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String num = sc.next();
        char[] c = num.toCharArray();
        BigInteger bg = BigInteger.ZERO;
        BigInteger cnt = new BigInteger("1");
        for(int i = c.length - 1; i >= 0; i--)
        {
        	BigInteger tmp = BigInteger.ONE;
        	tmp = tmp.multiply(new BigInteger(Integer.toString(c[i] - '0')));
        	tmp = tmp.multiply(cnt);
        	bg = bg.add(tmp);
        	cnt = cnt.multiply(new BigInteger("2"));
        }
        bg = bg.multiply(new BigInteger("17"));
        System.out.println(bg.toString(2));
        
	}
}