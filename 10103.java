import java.util.*;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int round = sc.nextInt();
        int chang = 100, sang = 100;
        for(int t = 0; t < round; t++)
        {
        	int a = sc.nextInt();
        	int b = sc.nextInt();
        	if(a > b) sang -= a;
        	else if(a < b) chang -= b;        		
        }
        System.out.println(chang);
        System.out.println(sang);
    }
}