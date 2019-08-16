import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		
		for(int test_case = 1; test_case <= tc; test_case++)
		{
			int min = Integer.MAX_VALUE;
			String s = sc.next();
			s = s.replaceAll(",", " ");
			String[] o = s.split(" ");
			HashMap<String, Integer> hs = new HashMap<>();
			for(int i = 0; i < o.length; i++)
			{
				String[] str = o[i].split(":");
				hs.put(str[0], Integer.parseInt(str[1]));
			}
			
			s = sc.next();
			s = s.replaceAll("\\|", " ");
//			System.out.println(s);
			String[] m = s.split(" ");
			for(int i = 0; i < m.length; i++)
			{
				int max = 0;
				String tmp = m[i].replaceAll("&", " ");
				String[] str = tmp.split(" ");
				
				for(int j = 0; j < str.length; j++)
				{
//					System.out.println(str[j]);
					if(!hs.containsKey(str[j])) continue;
					max = Math.max(max, hs.get(str[j]));
				}
				min = Math.min(min, max);
			}
//			System.out.println("========");
			System.out.println(min);
		}
	}
}