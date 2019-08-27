import java.util.*;

public class Main {
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		String N = sc.next();
		String[] ze = N.split("0");
		String[] on = N.split("1");
		int one = 0, zero = 0;
		for(int i = 0; i < ze.length; i++)
		{
			if(ze[i].length() > 0)
				zero++;
		}
		
		for(int i = 0; i < on.length; i++)
		{
			if(on[i].length() > 0)
				one++;
		}
		
		System.out.println(Math.min(one, zero));
		
	}
}