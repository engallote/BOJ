import java.util.*;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int u = 10000, c = 100000, p = 100000, c2 = -1;
        for(int i = 0; i < str.length(); i++)
        {
        	if(str.charAt(i) == 'U')
        		u = Math.min(u, i);
        	else if(str.charAt(i) == 'C')
        	{
        		if(i > u && c > i)
        			c = i;
        		else if(i > c && c2 < i)
        			c2 = i;
        	}
        	else if(str.charAt(i) == 'P')
        		if(i > c)
        			p = i;
        	if(u < c && c < p && p < c2) break;
        }
//        System.out.println(u + " " + c + " " + p + " " + c2);
        if(u < c && c < p && p < c2)
        	System.out.println("I love UCPC");
        else
        	System.out.println("I hate UCPC");
    }
}