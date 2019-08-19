import java.util.*;

public class Main {
	static boolean flag = false;
	static int[][] arr = new int[20][20];
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int ans = -1;
        for(int i = 1; i <= N; i++)
        {
        	int x = sc.nextInt();
        	int y = sc.nextInt();
        	if(i % 2 == 0)//¹é
        		arr[x][y] = 2;
        	else//Èæ
        		arr[x][y] = 1;
        	if(!flag)
        	{
        		find(x, y);
        		if(flag) ans = i;
        	}
        	if(flag) break;
        }
        System.out.println(ans);
    }
	private static void find(int x, int y) {
		int cur = arr[x][y];
		int x1 = x - 1, x2 = x + 1, y1 = y - 1, y2 = y + 1;
		int cnt = 1;
		while(x1 >= 1 && arr[x1][y] == cur)
		{
			cnt++;
			x1--;
		}
		while(x2 <= 19 && arr[x2][y] == cur)
		{
			cnt++;
			x2++;
		}
		if(cnt == 5)
		{
			flag = true;
			return;
		}
		
		cnt = 1;
		while(y1 >= 1 && arr[x][y1] == arr[x][y])
		{
			y1--;
			cnt++;
		}
		while(y2 <= 19 && arr[x][y2] == arr[x][y])
		{
			y2++;
			cnt++;
		}
		if(cnt == 5)
		{
			flag = true;
			return;
		}
		
		cnt = 1;
		x1 = x - 1;
		y1 = y - 1;
		x2 = x + 1;
		y2 = y + 1;
		while(x1 >= 1 && y1 >= 1 && arr[x1][y1] == cur)
		{
			x1--;
			y1--;
			cnt++;
		}
		while(x2 <= 19 && y2 <= 19 && arr[x2][y2] == cur)
		{
			x2++;
			y2++;
			cnt++;
		}
		if(cnt == 5)
		{
			flag = true;
			return;
		}
		
		cnt = 1;
		x1 = x - 1;
		y1 = y - 1;
		x2 = x + 1;
		y2 = y + 1;
		while(x1 >= 1 && y2 <= 19 && arr[x1][y2] == arr[x][y])
		{
			x1--;
			y2++;
			cnt++;
		}
		while(x2 <= 19 && y1 >= 1 && arr[x2][y1] == arr[x][y])
		{
			x2++;
			y1--;
			cnt++;
		}
		if(cnt == 5)
		{
			flag = true;
			return;
		}
	}
}