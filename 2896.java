import java.util.*;

public class Main {
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		double a = sc.nextDouble();
		double b = sc.nextDouble();
		double c = sc.nextDouble();
		
		double min = 100000;
		double aa = sc.nextDouble();
		double bb = sc.nextDouble();
		double cc = sc.nextDouble();
		min = Math.min(a / aa, b / bb);
		min = Math.min(min, c / cc);
		
		aa *= min;
		bb *= min;
		cc *= min;
		
		System.out.printf("%f %f %f\n", a - aa, b - bb, c - cc);
	}
}