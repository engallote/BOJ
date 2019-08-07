import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		HashMap<Integer, Integer> hs = new HashMap<>();
		for(int i = 0; i < N; i++)
		{
			int n = sc.nextInt();
			int m = sc.nextInt();
			hs.put(n, m);
		}
		
		int M = sc.nextInt();
		Queue<Integer> q = new LinkedList<>();
		for(int i = 0; i < M; i++)
		{
			int R = sc.nextInt();
			q.clear();
			for(int j = 0; j < R; j++)
			{
				int num = sc.nextInt();
				if(hs.containsKey(num)) q.add(hs.get(num));
			}
			
			if(q.size() != R) System.out.println("YOU DIED");
			else 
			{
				while(!q.isEmpty())
					System.out.print(q.poll() + " ");
				System.out.println();
			}
		}
	}
}