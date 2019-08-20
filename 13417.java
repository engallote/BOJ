import java.util.*;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        
        for(int test_case = 1; test_case <= tc; test_case++)
        {
        	int N = sc.nextInt();
        	Vector<Character> v = new Vector<>();
        	char pre = '.';
        	for(int i = 0; i < N; i++)
        	{
        		char c = sc.next().charAt(0);
        		if(i == 0)
        		{
        			v.addElement(c);
        			pre = c;
        		}
        		else
        		{
        			if(pre < c)
        				v.add(c);
        			else
        			{
        				v.add(0, c);
        				pre = c;
        			}
        		}
        	}
        	
        	for(char c : v)
        		System.out.print(c);
        	System.out.println();
        }
    }
}