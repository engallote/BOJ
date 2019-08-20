import java.util.*;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] p = sc.next().toCharArray();
        char[] d = sc.next().toCharArray();
        
        if(p.length < d.length)
        	System.out.println("no");
        else
        	System.out.println("go");
    }
}