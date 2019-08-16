import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext())
		{
			double H = sc.nextDouble();
			double P = sc.nextDouble();
			
			System.out.printf("%.2f\n", (H/P));
		}
	}
}