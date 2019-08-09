import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int t = 0; t < 3; t++)
		{
			int cnt = 0;
			String[] st = sc.next().split(":");
			int[] start = new int[3];
			start[0] = Integer.parseInt(st[0]);
			start[1] = Integer.parseInt(st[1]);
			start[2] = Integer.parseInt(st[2]);
			String tt = "";
			tt += st[0] + st[1] + st[2];
			int t2 = Integer.parseInt(tt);
			if(t2 % 3 == 0) cnt++;
			st = sc.next().split(":");
			int[] end = new int[3];
			end[0] = Integer.parseInt(st[0]);
			end[1] = Integer.parseInt(st[1]);
			end[2] = Integer.parseInt(st[2]);
			while(true)
			{
				start[2]++;
				if(start[2] == 60)
				{
					start[2] = 0;
					start[1]++;
				}
				if(start[1] == 60)
				{
					start[1] = 0;
					start[0]++;
				}
				if(start[0] == 24)
				{
					start[0] = 0;
				}
				
				String tmp = "";
				tmp += start[0];
				tmp += start[1];
				tmp += start[2];
				int num = Integer.parseInt(tmp);
				
				if(num % 3 == 0) cnt++;
				
				if(start[0] == end[0] && start[1] == end[1] && start[2] == end[2])
					break;
			}
			System.out.println(cnt);
		}
	}
}