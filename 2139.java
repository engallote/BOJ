import java.util.*;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true)
        {
        	int d = sc.nextInt();
        	int m = sc.nextInt();
        	int y = sc.nextInt();
        	
        	if(d == 0 && m == 0 && y == 0) break;
        	
        	int res = 0;
        	if((y % 4 == 0 && y % 100 != 0) || y % 400 == 0)//À±³â
        	{
        		for(int i = 1; i < m; i++)
        		{
        			if(i == 2)
        				res += 29;
        			else if(i == 4 || i == 6 || i == 9 || i == 11)
        				res += 30;
        			else
        				res += 31;
        		}
        		res += d;
        	}
        	else
        	{
        		for(int i = 1; i < m; i++)
        		{
        			if(i == 2)
        				res += 28;
        			else if(i == 4 || i == 6 || i == 9 || i == 11)
        				res += 30;
        			else
        				res += 31;
        		}
        		res += d;
        	}
        	System.out.println(res);
        }
    }
}