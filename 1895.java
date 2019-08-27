import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int R = sc.nextInt();
		int C = sc.nextInt();
		int[][] map = new int[R][C];
		Vector<Integer> v = new Vector<>(), tmp = new Vector<>();
		
		for(int i = 0; i < R; i++)
			for(int j = 0; j < C; j++)
				map[i][j] = sc.nextInt();
		
		int T = sc.nextInt();
		int sx = 0, sy = 0, ex = 2, ey = 2;
		
		while(ex < R)
		{
			tmp.clear();
			for(int i = sx; i <= ex; i++)
				for(int j = sy; j <= ey; j++)
					tmp.add(map[i][j]);
			
			tmp.sort(null);
			v.add(tmp.get(4));
			
			sy++;
			ey++;
			if(ey == C)
			{
				sx++;
				ex++;
				sy = 0;
				ey = 2;
			}
		}
		int cnt = 0;
		
		v.sort(null);
		for(int n : v)
			if(n >= T)
				cnt++;
		
		System.out.println(cnt);	
	}
}