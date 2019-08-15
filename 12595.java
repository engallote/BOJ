import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = sc.nextInt();
			HashMap<String, Integer> hs = new HashMap<>();
			
			for(int i = 0; i < N; i++)
			{
				String num = sc.next();
				if(hs.containsKey(num))
				{
					int value = hs.get(num) + 1;
					hs.replace(num, value);
				}
				else hs.put(num, 1);
			}
			String res = "";
			System.out.print("Case #" + test_case + ": ");
			Iterator<String> it = hs.keySet().iterator();
			while(it.hasNext())
			{
				String key = it.next();
				int value = hs.get(key);
				
				if(value == 1)
				{
					res = key;
					break;
				}
			}
			System.out.println(res);
		}
	}
}