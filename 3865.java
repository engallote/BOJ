import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true)
		{
			int N = sc.nextInt();
			if(N == 0) break;
			HashMap<String, Integer> name = new HashMap<>();
			ArrayList<Integer>[] arr = new ArrayList[100000];
			for(int i = 0; i < 100000; i++)
				arr[i] = new ArrayList<>();
			int idx = 0;
			for(int i = 0; i < N; i++)
			{
				String s = sc.next();
				s = s.replace(".", "");
				String[] str = s.split(":");
				int index = 0;
				if(name.containsKey(str[0]))
					index = name.get(str[0]);
				else
				{
					index = idx;
					name.put(str[0], idx++);
				}
				String[] str2;
				if(str[1].contains(",")) str2 = str[1].split(",");
				else
				{
					str2 = new String[1];
					str2[0] = str[1];
				}
				for(int j = 0; j < str2.length; j++)
				{
					if(name.containsKey(str2[j]))
						arr[index].add(name.get(str2[j]));
					else
					{
						arr[index].add(idx);
						name.put(str2[j], idx++);
					}
				}
			}
			
			long cnt = 0;
			boolean[] chk = new boolean[100000];
			Queue<Integer> q = new LinkedList<>();
			q.add(0);
			chk[0] = true;
			
			while(!q.isEmpty())
			{
				int x = q.poll();
				if(arr[x].size() == 0) cnt++;
				for(int next : arr[x])
					if(!chk[next])
					{
						chk[next] = true;
						q.add(next);
					}
			}
			System.out.println(cnt);
		}
	}
}