import java.util.*;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true)
        {
        	String num1 = sc.next();
        	String num2 = sc.next();
        	if(num1.equals("0") && num2.equals("0")) break;
        	char[] a = num1.toCharArray();
        	char[] b = num2.toCharArray();
        	boolean flag = false;
        	int carry = 0, i, j;
        	for(i = a.length - 1, j = b.length - 1; i >= 0 && j >= 0; i--, j--)
        	{
        		if(flag)//carry ¹ß»ý
        		{
        			flag = false;
        			if((a[i] - '0') + (b[j] - '0') + 1 >= 10)
        			{
        				flag = true;
        				carry++;
        			}
        		}
        		else
        		{
        			if((a[i] - '0') + (b[j] - '0') >= 10)
        			{
        				flag = true;
        				carry++;
        			}
        		}
        	}
        	if(flag)
        	{
        		if(i >= 0 && j < 0)
        		{
        			for(; i >= 0; i--)
        			{
        				if(flag)
        				{
        					flag = false;
        					if((a[i] - '0') + 1 >= 10)
        					{
        						flag = true;
        						carry++;
        					}
        				}
        			}
        		}
        		else if(i < 0 && j >= 0)
        		{
        			for(; j >= 0; j--)
        			{
        				if(flag)
        				{
        					flag = false;
        					if((b[j] - '0') + 1 >= 10)
        					{
        						flag = true;
        						carry++;
        					}
        				}
        			}
        		}
        	}
        	System.out.println(carry);
        }
    }
}