import java.util.*;

public class Main {
	static long[] arr,  tree;
	static int mod = 1000000007;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int K = sc.nextInt();
		int len = (int)Math.pow(2, Math.ceil(Math.log(N) / Math.log(2)) + 1);
		arr = new long[N];
		tree = new long[len];
		
		for(int i = 0; i < N; i++)
			arr[i] = sc.nextLong();
		
		make(1, 0, N-1);
		
		M += K;
		for(int i = 0; i < M; i++)
		{
			int y = sc.nextInt();
			if(y == 1)
			{
				int a = sc.nextInt()-1;
				int b = sc.nextInt();
				arr[a] = b;
				update(1, 0, N-1, a);
			}
			else
			{
				int a = sc.nextInt()-1;
				int b = sc.nextInt()-1;
				if(a > b)
				{
					int tmp = a;
					a = b;
					b = tmp;
				}
				System.out.println(mul(1, 0, N-1, a, b) % mod);
			}
		}
	}
	private static long update(int node, int start, int end, int idx) {
		if(idx < start || idx > end) return tree[node];
		if(start == end)
			return tree[node] = arr[start];
		return tree[node] = (update(node * 2, start, (start + end) / 2, idx) * 
				update(node * 2 + 1, (start + end) / 2 + 1, end, idx)) % mod;
	}
	private static long mul(int node, int start, int end, int left, int right) {
		if(left > end || right < start) return 1;
		if(left <= start && end <= right) return tree[node];
		return (mul(node * 2, start, (start + end) / 2, left, right)
				* mul(node * 2 + 1, (start + end) / 2 + 1, end, left, right)) % mod;
	}
	private static long make(int node, int start, int end) {
		if(start == end)
			return tree[node] = arr[start];
		else
			return tree[node] = (make(node * 2, start, (start + end) / 2)
							* make(node * 2 + 1, (start + end) / 2 + 1, end))%mod;
	}
}