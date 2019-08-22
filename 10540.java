import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int xmin = 1000000000, xmax = 0, ymin = 1000000000, ymax = 0;
		for(int i = 0; i < N; i++)
		{
			int x = sc.nextInt();
			int y = sc.nextInt();
			if(xmin > x)
				xmin = x;
			if(xmax < x)
				xmax = x;
			if(ymin > y)
				ymin = y;
			if(ymax < y)
				ymax = y;
		}
		
		int res = Math.max(xmax - xmin, ymax - ymin);
		System.out.println(res*res);
	}
}