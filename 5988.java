import java.math.BigInteger;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		
		for(int test_case = 1; test_case <= tc; test_case++)
		{
			BigInteger num = new BigInteger(sc.next());
			BigInteger mod = num.mod(new BigInteger("2"));
			if(mod.toString().equals("0"))
				System.out.println("even");
			else
				System.out.println("odd");
		}
	}
}