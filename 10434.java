import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		boolean[] chk = new boolean[10001];
		chk[0] = chk[1] = true;
		
		for(int i = 2; i <= 10000; i++)
		{
			if(chk[i]) continue;
			for(int j = i + i; j <= 10000; j+=i)
				chk[j] = true;
		}
		for(int t = 0; t < tc; t++)
		{
			int tNum = sc.nextInt();
			int num = sc.nextInt();
			StringBuilder ans = new StringBuilder();
			ans.append(tNum + " " + num + " ");
			if(chk[num])
				ans.append("NO");
			else
			{
				boolean flag = false;
				HashSet<Integer> hs = new HashSet<>();
				hs.add(num);
				while(true)
				{
					int tmp = 0;
					while(num > 0)
					{
						tmp += (num % 10) * (num % 10);
						num /= 10;
					}
					num = tmp;
					if(hs.contains(num)) break;
					else if(num == 1)
					{
						flag = true;
						break;
					}
					hs.add(num);
				}
				if(flag) ans.append("YES");
				else ans.append("NO");
			}
			System.out.println(ans.toString());
		}
	}
}