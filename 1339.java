import java.util.*;

public class Main {
	static int[] alp = new int[26];
	static boolean[] visit = new boolean[26];
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String[] str = new String[N];
		int[] res = new int[N];
		
		int max = 0;
		
		for(int i = 0; i < N; i++)
		{
			str[i] = sc.next();
			int len = str[i].length();
			for(int j = 0; j < str[i].length(); j++)
			{
				int num = str[i].charAt(j) - 'A';
				alp[num] += (int) Math.pow(10, len);
				len--;
				if(max < alp[num])
					max = alp[num];
			}
		}
		
		int cnt = 9;
		while(cnt >= 0)
		{
			solve(max, cnt);
			cnt--;
			
			max = 0;
			for(int i = 0; i < 26; i++)
				if(!visit[i] && max < alp[i])
					max = alp[i];
		}
				
		for(int i = 0; i < N; i++)
		{
			String s = "";
			for(int j = 0; j < str[i].length(); j++)
				s += alp[str[i].charAt(j) - 'A'];
			res[i] = Integer.parseInt(s);
		}
		
		int sum = 0;
		for(int i = 0; i < N; i++)
			sum += res[i];
		
		System.out.println(sum);
	}
	private static void solve(int max, int cnt) {
		
		for(int i = 0; i < 26; i++)
			if(alp[i] == max)
			{
				alp[i] = cnt;
				visit[i] = true;
				break;
			}
	}
}