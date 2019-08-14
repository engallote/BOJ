import java.util.*;

public class Main {
	static int N, M;
	static int[] arr;
	static ArrayList<Integer> aly;
	static HashSet<String> hs = new HashSet<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		aly = new ArrayList<>();
		arr = new int[N];
		
		for(int i = 0; i < N; i++)
			arr[i] = sc.nextInt();
		Arrays.sort(arr);
		solve(0, 0);
	}
	private static void solve(int cnt, int chk) {
		if(cnt == M)
		{
			StringBuilder sb = new StringBuilder();
			for(int i : aly)
				sb.append(i + " ");
			if(!hs.contains(sb.toString()))
			{
				hs.add(sb.toString());
				System.out.println(sb.toString());
			}
			return;
		}
		for(int i = 0; i < N; i++)
			if((chk&(1<<i)) == 0)
			{
				aly.add(arr[i]);
				solve(cnt + 1, chk | (1<<i));
				aly.remove(aly.size()-1);
			}
		
	}
}