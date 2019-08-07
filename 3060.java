import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			long N = sc.nextLong();
			long[] arr = new long[6], tmp = new long[6];
			long day = 1, food = N;
			for(int i = 0; i < 6; i++)
			{
				arr[i] = sc.nextLong();
				food -= arr[i];
			}
			
			while(food >= 0)
			{
				food = N;
				for(int i = 0; i < 6; i++)
				{
					tmp[i] = arr[(i+1)%6] + arr[(i+5)%6] + arr[(i+3)%6] + arr[i];
//					System.out.println(i + " => " + tmp[i]);
					food -= arr[i];
				}
//				System.out.println(food);
				if(food < 0) break;
//				System.out.println(day + " >> " + food);
				for(int i = 0; i < 6; i++)
					arr[i] = tmp[i];
				day++;
			}
			System.out.println(day);
		}
	}
}