import java.util.*;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        int g, b;
        for(int i = 0; i < N; i++)
        {
        	g = b = 0;
        	String name = sc.nextLine();
        	char[] c = name.toCharArray();
        	for(int j = 0; j < c.length; j++)
        	{
        		if(c[j] == 'G' || c[j] == 'g') g++;
        		else if(c[j] == 'B' || c[j] == 'b') b++;
        	}
        	if(g > b)
        		System.out.println(name + " is GOOD");
        	else if(g == b)
        		System.out.println(name + " is NEUTRAL");
        	else
        		System.out.println(name + " is A BADDY");
        }
    }
}