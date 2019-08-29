import java.util.*;

public class Main {
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int cnt = 1;
		for(int i = 1; i < N; i++)
		{
			int sum = 0;
			for(int j = i; j < N; j++)
			{
				if(sum  + j == N)
				{
					cnt++;
					break;
				}
				else if(sum > N)
					break;
				sum += j;
			}
		}
		System.out.println(cnt);
	}
}