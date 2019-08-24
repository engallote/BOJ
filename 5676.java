import java.util.*;

public class Main {
	static long[] tree;
	static int[] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext())
		{
			int N = sc.nextInt();
			int K = sc.nextInt();
			int len = (int)Math.pow(2, Math.ceil(Math.log(N) / Math.log(2)) + 1);
			arr = new int[N];
			tree = new long[len];
			
			for(int i = 0; i < N; i++)
			{
				int num = sc.nextInt();
				if(num > 0)
					arr[i] = 1;
				else if(num == 0)
					arr[i] = 0;
				else
					arr[i] = -1;
			}
			
			make(1, 0, N-1);
			
			for(int i = 0; i < K; i++)
			{
				char c = sc.next().charAt(0);
				if(c == 'C')
				{
					int idx = sc.nextInt()-1;
					int b = sc.nextInt();
					if(b > 0)
						arr[idx] = 1;
					else if(b == 0)
						arr[idx] = 0;
					else
						arr[idx] = -1;
					update(1, 0, N-1, idx);
				}
				else
				{
					int a = sc.nextInt()-1;
					int b = sc.nextInt()-1;
					long res = mul(1, 0, N-1, a, b);
					if(res < 0)
						System.out.print("-");
					else if(res == 0)
						System.out.print(0);
					else
						System.out.print("+");
				}
			}
			System.out.println();
		}
	}
	private static long mul(int node, int start, int end, int left, int right) {
		if(left > end || right < start) return 1;
		if(left <= start && end <= right)
			return tree[node];
		return mul(node * 2, start, (start + end) / 2, left, right)
				* mul(node * 2 + 1, (start + end) / 2 + 1, end, left, right);
	}
	private static long update(int node, int start, int end, int idx) {
		if(idx < start || idx > end) return tree[node];
		if(start == end)
			return tree[node] = arr[start];
		return tree[node] = (update(node * 2, start, (start + end) / 2, idx)
							* update(node * 2 + 1, (start + end) / 2 + 1, end, idx));
	}
	private static long make(int node, int s, int e) {
		if(s == e)
			return tree[node] = arr[s];
		else
			return tree[node] = make(node * 2, s, (s + e) / 2) * make(node * 2 + 1, (s + e) / 2 + 1, e);
	}
}