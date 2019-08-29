import java.math.BigInteger;
import java.util.*;

public class Main {
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		BigInteger A = new BigInteger(sc.next());
		BigInteger B = new BigInteger(sc.next());
		BigInteger C = new BigInteger("0");
		
		C = A.add(B);
		System.out.println(C);
		
		C = A.subtract(B);
		System.out.println(C);
		
		C = A.multiply(B);
		System.out.println(C);
	}
}