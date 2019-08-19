import java.util.*;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        
        for(int t = 0; t < tc; t++)
        {
        	int a = sc.nextInt();
        	int b = sc.nextInt();
        	
        	System.out.printf("You get %d piece(s) and your dad gets %d piece(s).\n", (a/b), (a%b));
        }
    }
}