import java.util.*;

public class Main {
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		String[] ox = new String[n];
		int sum,tmp;
		int length = 0;
		
		for(int i = 0; i < n; i++)
		{
			ox[i] = sc.next();
			length = ox[i].length();
		}
		
		if((length>0)&&(length<80))
		{
			for(int i = 0; i < n; i++)
			{
				char[] ox2 = ox[i].toCharArray();
				sum = 0;
				tmp = 0;
				
				for(int j = 0; j < ox[i].length(); j++)
				{				
					
					if(ox2[j] == 'X')
					{
						tmp = 0;
						sum = sum + tmp;
					}
					
					else
					{
						tmp++;
						sum = sum + tmp;
					}
				}
				System.out.println(sum);
			}
		}
		else
		{
			System.out.println("0보다 크고 80보다 작은 문자열을 입력해주세요.");
		}
	}
}