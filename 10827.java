import java.math.BigDecimal;
import java.util.*;

public class Main {
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		double a = sc.nextDouble();
		int b = sc.nextInt();
		BigDecimal A = new BigDecimal(String.valueOf(a));
		BigDecimal res = new BigDecimal("1");
		
		for(int i = 0; i < b; i++)
			res = res.multiply(A);
		
		System.out.println(res.toPlainString());
	}
}