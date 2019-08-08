import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int[] arr = new int[N];
		for(int i = 0; i < N; i++)
			arr[i] = sc.nextInt();
		boolean[] chk = new boolean[N];
		Queue<Integer> q = new LinkedList<>();
		q.add(0);
		boolean flag = true;
		chk[0] = true;
		int cnt = 1;
		while(!q.isEmpty())
		{
			int x = q.poll();
//			System.out.println(x);
			if(arr[x] == M) break;
			if(chk[arr[x]])
			{
				flag = false;
				break;
			}
			q.add(arr[x]);
			chk[arr[x]] = true;
			cnt++;
		}
		
		System.out.println(flag ? cnt : -1);
	}
}