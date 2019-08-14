import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt() - 1;
		String[] str = {"baby", "sukhwan", "tururu", "turu", "very", "cute", "tururu", "turu",
				"in", "bed", "tururu", "turu", "baby", "sukhwan"};
		int cnt = N / 14;
		N %= 14;
		
		if(str[N].contains("tu"))
		{
			if(N == 2 || N == 6 || N == 10)
			{
				cnt += 2;
				if(cnt >= 5)
					System.out.println("tu+ru*"+cnt);
				else
				{
					System.out.print("tu");
					while(cnt > 0) 
					{
						System.out.print("ru");
						cnt--;
					}
					System.out.println();
				}
			}			
			else
			{
				cnt++;
				if(cnt >= 5)
					System.out.println("tu+ru*"+cnt);
				else
				{
					System.out.print("tu");
					while(cnt > 0) 
					{
						System.out.print("ru");
						cnt--;
					}
					System.out.println();
				}
			}
		}
		else System.out.println(str[N]);
	}
}