import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int cnt = 0;
		int[][] arr = new int[3][2];
		
		for(int i = 0; i < N; i++)
		{
			int s = sc.nextInt();
			int y = sc.nextInt();
			if(y == 1 || y == 2)
				arr[0][0]++;
			else if(y == 3 || y == 4)
				arr[1][s]++;
			else if(y == 5 || y == 6)
				arr[2][s]++;
		}
		int tmp = 0;
		while(arr[0][0] > 0)
		{
			tmp++;
			arr[0][0]--;
			if(tmp == K)
			{
				cnt++;
				tmp = 0;
			}
		}
		if(tmp > 0)
			cnt++;
		tmp = 0;
		
		while(arr[1][0] > 0)
		{
			tmp++;
			arr[1][0]--;
			if(tmp == K)
			{
				cnt++;
				tmp = 0;
			}
		}
		if(tmp > 0)
			cnt++;
		tmp = 0;
		while(arr[1][1] > 0)
		{
			tmp++;
			arr[1][1]--;
			if(tmp == K)
			{
				cnt++;
				tmp = 0;
			}
		}
		if(tmp > 0)
			cnt++;
		tmp = 0;
		
		while(arr[2][0] > 0)
		{
			tmp++;
			arr[2][0]--;
			if(tmp == K)
			{
				cnt++;
				tmp = 0;
			}
		}
		if(tmp > 0)
			cnt++;
		tmp = 0;
		while(arr[2][1] > 0)
		{
			tmp++;
			arr[2][1]--;
			if(tmp == K)
			{
				cnt++;
				tmp = 0;
			}
		}
		if(tmp > 0)
			cnt++;
		System.out.println(cnt);
	} 
}