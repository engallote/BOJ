import java.util.*;

public class Main {
	static int res = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int res = 0;
		for(int i = 0; i < N; i++)
		{
			String[] str = sc.next().split(":");
			int h = Integer.parseInt(str[0]);
			int m = Integer.parseInt(str[1]);
			int call = sc.nextInt();
			if(7 <= h && h < 19)
			{
				if(m + call < 60)
					res += (call * 10);
				else
				{
					h++;
					if(h == 24) h = 0;
					int tmp = (m + call) % 60;
					if(h == 19)
					{
						if(tmp == 0)
							res += (call * 10);
						else
						{
							res += (call - tmp) * 10;
							res += tmp * 5;
						}
					}
					else
						res += call * 10;
				}
			}
			else
			{
				if(m + call < 60)
					res += (call * 5);
				else
				{
					h++;
					if(h == 24) h = 0;
					int tmp = (m + call) % 60;
					if(h == 7)
					{
						if(tmp == 0)
							res += (call * 5);
						else
						{
							res += (call - tmp) * 5;
							res += tmp * 10;
						}
					}
					else
						res += call * 5;
				}
			}
		}
		System.out.println(res);
	}
}