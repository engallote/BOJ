import java.util.*;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        for(int test_case = 1; test_case <= tc; test_case++)
        {
        	char[] c = sc.next().toCharArray();
        	int len = c.length;
        	
        	StringBuilder a = new StringBuilder(), b = new StringBuilder();
        	if(len % 2 == 0)
        	{
        		for(int i = 0; i < len; i++)
        		{
        			if(i % 2 == 0)
        				a.append(c[i]);
        			else
        				b.append(c[i]);
        		}
        	}
        	else
        	{
        		for(int i = 0; i < len; i++)
        		{
        			if(i % 2 == 0)
        				a.append(c[i]);
        			else
        				b.append(c[i]);
        		}
        		for(int i = 0; i < len; i++)
        		{
        			if(i % 2 == 0)
        				b.append(c[i]);
        			else
        				a.append(c[i]);
        		}
        	}
        	System.out.println(a.toString());
        	System.out.println(b.toString());
        }
    }
}