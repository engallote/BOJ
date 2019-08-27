import java.util.*;

public class Main {
	static int max = 1000001;
	static boolean[] chk = new boolean[1000001];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		for(int i = 2; i <= max-1; i++)
		{
			if(chk[i]) continue;
			for(int j = i + i; j <= max - 1; j+=i)
				chk[j] = true;
		}
		
		Vector<Integer> v = new Vector<>();
		for(int i = 3; i <= num; i++)
		{
			if(chk[i]) continue;
			String s = Integer.toString(i);
			boolean flag = false;
			HashSet<Integer> hs = new HashSet<>();
			while(!s.equals("1"))
			{
				int sum = 0;
				for(int j = 0; j < s.length(); j++)
					sum += Math.pow(s.charAt(j) - '0', 2);
				if(hs.contains(sum))
					break;
				if(sum == 1)
				{
					flag = true;
					break;
				}
				hs.add(sum);
				s = Integer.toString(sum);
			}
			
			if(flag)
				v.add(i);
		}
		v.sort(null);
		
		for(int i : v)
			System.out.println(i);
	}
}