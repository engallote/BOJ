import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		
		for(int t = 0; t < tc; t++)
		{
			double N = sc.nextDouble();
			String d = sc.next();
			
			if(d.equals("kg"))
			{
				N *= 2.2046;
				d = " lb";
			}
			else if(d.equals("lb"))
			{
				N *= 0.4536;
				d = " kg";
			}
			else if(d.equals("l"))
			{
				N *= 0.2642;
				d = " g";
			}
			else
			{
				N *= 3.7854;
				d = " l";
			}
			System.out.printf("%.4f%s\n", N, d);
		}
	}
}