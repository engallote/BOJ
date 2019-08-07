import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = sc.nextInt();
			HashMap<String, Integer> hs = new HashMap<>();
			String[] name = new String[30];
			boolean[] chk = new boolean[30];
			int idx = 0;
			for(int i = 0; i < N; i++)
			{
				String str = sc.next();
				name[idx] = str;
				hs.put(str, idx++);
			}
				
			int M = sc.nextInt();
			sc.nextLine();
			for(int i = 0; i < M; i++)
			{
				String[] str = sc.nextLine().split(" ");
				for(int j = 0; j < str.length; j++)
					if(hs.containsKey(str[j]))
						chk[hs.get(str[j])] = true;
			}
			
			System.out.println("Test set " + test_case + ":");
			for(int i = 0; i < idx; i++)
			{
				if(chk[i]) System.out.println(name[i] + " is present");
				else System.out.println(name[i] + " is absent");
			}
			System.out.println();
		}
	}
}