import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};
		for(int t = 0; t < N; t++)
		{
			char[] c = sc.next().toCharArray();
			int x1 = 0, x2 = 0, y1 = 0, y2 = 0;
			int x = 0, y = 0, d = 0;
			
			for(int i = 0; i < c.length; i++)
			{
				if(c[i] == 'F')
				{
					x += dx[d];
					y += dy[d];
				}
				else if(c[i] == 'B')
				{
					int tmp = (d + 2) % 4;
					x += dx[tmp];
					y += dy[tmp];
				}
				else if(c[i] == 'L') d = d - 1 >= 0 ? d - 1 : 3;
				else d = d + 1 < 4 ? d + 1 : 0;
				x1 = Math.min(x1, x);
				x2 = Math.max(x2, x);
				y1 = Math.min(y1, y);
				y2 = Math.max(y2, y);
			}
//			System.out.println("----");
//			System.out.println(x1 + " " + x2);
//			System.out.println(y1 + " " + y2);
			System.out.println((x2 - x1) * (y2 - y1));
		}
	}
}