import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String a1 = sc.next();
		String a2 = sc.next();
		String b1 = sc.next();
		String b2 = sc.next();
		
		if(a1.equals(a2))
		{
			if(a1.equals("R"))
			{
				if(b1.equals("P") || b2.equals("P")) System.out.println("TK");
				else if(b1.equals("R") || b2.equals("R")) System.out.println("?");
				else System.out.println("MS");
			}
			else if(a1.equals("S"))
			{
				if(b1.equals("R") || b2.equals("R")) System.out.println("TK");
				else if(b1.equals("S") || b2.equals("S")) System.out.println("?");
				else System.out.println("MS");
			}
			else if(a1.equals("P"))
			{
				if(b1.equals("S") || b2.equals("S")) System.out.println("TK");
				else if(b1.equals("P") || b2.equals("P")) System.out.println("?");
				else System.out.println("MS");
			}
		}
		else if(b1.equals(b2))
		{
			if(b1.equals("R"))
			{
				if(a1.equals("P") || a2.equals("P")) System.out.println("MS");
				else if(a1.equals("R") || a2.equals("R")) System.out.println("?");
				else System.out.println("TK");
			}
			else if(b1.equals("S"))
			{
				if(a1.equals("R") || a2.equals("R")) System.out.println("MS");
				else if(a1.equals("S") || a2.equals("S")) System.out.println("?");
				else System.out.println("TK");
			}
			else if(b1.equals("P"))
			{
				if(a1.equals("S") || a2.equals("S")) System.out.println("MS");
				else if(a1.equals("P") || a2.equals("P")) System.out.println("?");
				else System.out.println("TK");
			}
		}
		else System.out.println("?");
		
	}
}