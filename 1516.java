import java.util.*;

public class Main {
	static int N;
	static int[] inDgree, time;
	static ArrayList<ArrayList<Integer>> aly = new ArrayList<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		inDgree = new int[N];
		time = new int[N];
		for(int i = 0; i < N; i++)
			aly.add(new ArrayList<>());
		
		for(int i = 0; i < N; i++)
		{
			int n = sc.nextInt();
			time[i] = n;
			while(true)
			{
				n = sc.nextInt();
				if(n == -1) break;
				n -= 1;
				aly.get(n).add(i);
				inDgree[i]++;
			}
		}
		
		solve();
	}
	private static void solve() {
		int[] max = new int[N];
		Queue<Integer> q = new LinkedList<>();
		for(int i = 0; i < N; i++)
			if(inDgree[i] == 0)
				q.offer(i);
		
		for(int i = 0; i < N; i++)
		{
			if(q.isEmpty()) return;//����Ŭ �߻�
			int x = q.poll();
			for(int j = 0; j < aly.get(x).size(); j++)
			{
				int y = aly.get(x).get(j);
				max[y] = Math.max(max[x] + time[x], max[y]);//x�� + x�� max���� ���� ������ max�� ��
				/*
				 max[0] = 0;
				 ------------ 0�� ���ҵ� -------------
				 max[1] = Math.max(max[0] + time[0], max[1]) = 10;
				 max[2] = Math.max(max[0] + time[0], max[2]) = 10;
				 max[3] = Math.max(max[0] + time[0], max[3]) = 10;
				 ------------ 3�� ���ҵ� -------------
				 max[3] = Math.max(max[2] + time[2], max[3]) = Math.max(10 + 4, 10) = 14;
				 max[4] = Math.max(max[2] + time[2], max[4]) = Math.max(10 + 4, 0) = 14;
				 */
				if(--inDgree[y] == 0)
				{
					q.offer(y);
				}
			}
		}
		
		for(int i = 0; i < N; i++)
		{
//			System.out.println(">> " + max[i]);
			System.out.println(time[i]+max[i]);
		}
	}
}