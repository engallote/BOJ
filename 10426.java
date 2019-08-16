import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] str = sc.next().split("-");
		int year = Integer.parseInt(str[0]);
		int month = Integer.parseInt(str[1]);
		int day = Integer.parseInt(str[2]);
		int num = sc.nextInt() - 1;
		
		while(num > 0)
		{
			if(month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12){
				day++;
				if(day == 32)
				{
					day = 1;
					month++;
					if(month == 13)
					{
						month = 1;
						year++;
					}
				}
			}
			else if(month == 2){
				if(year % 400 == 0 || (year % 4 == 0 && year % 100 != 0))
				{
					day++;
					if(day == 30)
					{
						day = 1;
						month++;
					}
				}
				else
				{
					day++;
					if(day == 29) 
					{
						day = 1;
						month++;
					}
				}
			}
			else
			{
				day++;
				if(day == 31)
				{
					day = 1;
					month++;
					if(month == 13)
					{
						month = 1;
						year++;
					}
				}
			}
			num--;
		}
		System.out.printf("%d-%02d-%02d", year, month, day);
	}
}