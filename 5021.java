import java.util.*;

public class Main {
	static int N, M;
	static HashMap<String, Double> hs = new HashMap<>();
	static boolean[] chk;
	static String[][] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		String king = sc.next();
		hs.put(king, 1.0);
		int idx = 1;
		arr = new String[N+1][3];
		
		for(int i = 0; i < N; i++)
		{
			String a = sc.next();
			String b = sc.next();
			String c = sc.next();
			
			if(!hs.containsKey(a))
				hs.put(a, 0.0);
			if(!hs.containsKey(b))
				hs.put(b, 0.0);
			if(!hs.containsKey(c))
				hs.put(c, 0.0);
			
			arr[i][0] = a;
			arr[i][1] = b;
			arr[i][2] = c;
		}
		
		chk = new boolean[idx+1];
		Queue<String> q = new LinkedList<String>();
		q.add(king);
		
		while(!q.isEmpty())
		{
			int size = q.size();
			for(int t = 0; t < size; t++)
			{
				String name = q.poll();
				for(int i = 0; i < N; i++)
					if(arr[i][1].equals(name) || arr[i][2].equals(name))
					{
						double value = (hs.get(arr[i][1]) + hs.get(arr[i][2])) / 2;
						hs.remove(arr[i][0]);
						hs.put(arr[i][0], value);
						q.add(arr[i][0]);
					}
			}
		}
		
		double max = -1;
		String nextKing = "";
		for(int i = 0; i < M; i++)
		{
			String name = sc.next();
			if(!hs.containsKey(name)) continue;
			if(max < hs.get(name))
			{
				max = hs.get(name);
				nextKing = name;
			}
		}
		System.out.println(nextKing);
	}
}