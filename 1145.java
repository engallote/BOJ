import java.util.*;

public class Main {
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[5];
		
		for(int i = 0; i < 5; i++)
			arr[i] = sc.nextInt();
		
		Arrays.sort(arr);
		int num = arr[2], cnt = 0, res = 0;
		
		for(int i = num; cnt < 3; i++)
		{
			cnt = 0;
			for(int j = 0; j < 5; j++)
			{
				if(i % arr[j] == 0)
					cnt++;
			}
			if(cnt >= 3)
			{
				res = i;
				break;
			}
		}
		System.out.println(res);
	}
}