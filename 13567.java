import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};
		
		int x = 0, y = 0, d = 1;
		boolean flag = true;
		for(int i = 0; i < M; i++)
		{
			String order = sc.next();
			int num = sc.nextInt();
			
			if(order.equals("MOVE"))
			{
				for(int j = 0; j < num; j++)
				{
					x += dx[d];
					y += dy[d];
				}
				if(x >= N || y >= N || x < 0 || y < 0) flag = false;
			}
			else
			{
				if(num == 0) d = (d + 1) % 4;
				else d = (d - 1) >= 0 ? d - 1 : 3;
			}
//			System.out.println(x + " " + y);
		}
		
		System.out.println(flag ? (y + " " + x) : -1);
	}
}