import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean f = true;
		
		long a = Long.MIN_VALUE, b = a;
		while(sc.hasNextInt())
		{
			a = sc.nextLong();
			if(a < b)
			{
				f = false;
				break;
			}
			else
				b = a;
		}
		if(f)
			System.out.println("Good");
		else
			System.out.println("Bad");
	}
}