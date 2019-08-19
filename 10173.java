import java.util.*;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true)
        {
        	String s = sc.nextLine();
        	if(s.equals("EOI")) break;
        	s = s.toLowerCase();
        	if(s.contains("nemo"))
        		System.out.println("Found");
        	else
        		System.out.println("Missing");
        }
    }
}