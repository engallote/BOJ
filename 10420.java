import java.util.*;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int year = 2014, month = 4, day = 2;
        int[] d = {0,31,28,31,30,31,30,31,31,30,31,30,31};
        
        while(N > 0)
        {
        	N--;
        	int tmp = 0;
        	if(month == 2 && ((year % 4 == 0 && year % 100 != 0)) || (year % 400 == 0))
        	{
        		tmp = 29 - day;
        		if(N > tmp)
        		{
        			N -= tmp;
        			month++;
        			day = 1;
        		}
        		else
        		{
        			if(day + N <= 29)
        				day += N;
        			else
        			{
        				tmp = day + N - 29;
        				month++;
        				day = tmp;
        			}
        			N = -1;
        		}
        	}
        	else if(d[month] - day >= 0)
        	{
        		tmp = d[month] - day;
        		if(N > tmp)
        		{
        			N -= tmp;
        			month++;
        			day = 1;
        		}
        		else
        		{
        			if(day + N <= d[month])
        				day += N;
        			else
        			{
        				tmp = day + N - d[month];
        				month++;
        				day = tmp;
        			}
        			N = -1;
        		}
        	}
        	if(month > 12)
        	{
        		year++;
        		month = 1;
        	}
        }
        System.out.println(year + "-"+(month < 10 ? "0"+month : month)+"-"+(day < 10 ? "0"+day : day));
    }
}