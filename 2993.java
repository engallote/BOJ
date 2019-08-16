import java.util.*;

public class Main {
	static char[] c;
	static String[][] dp;
	static int len;
	static String res;
	static PriorityQueue<String> pq = new PriorityQueue<>(Collections.reverseOrder());
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        c = sc.next().toCharArray();
        res = "";
        len = c.length;
        dp = new String[len][len];
        
        for(int i = 0; i < len; i++)
        	Arrays.fill(dp[i], ".");
        solve(1, len - 2);
        res = pq.peek();
        System.out.println(res);
	}
	private static String solve(int l, int r) {
		if(l > r) return "";
		if(!dp[l][r].equals(".")) return dp[l][r];
		StringBuilder ans = new StringBuilder(), tmp = new StringBuilder();
		
		for(int i = 0; i < l; i++)
			tmp.append(c[i]);
		tmp.reverse();
		ans.append(tmp.toString());
		tmp = new StringBuilder();
		
		for(int i = l; i <= r; i++)
			tmp.append(c[i]);
		tmp.reverse();
		ans.append(tmp.toString());
		tmp = new StringBuilder();
		
		for(int i = r + 1; i < len; i++)
			tmp.append(c[i]);
		tmp.reverse();
		ans.append(tmp.toString());
		
		pq.add(ans.toString());
		if(pq.size() > 1) pq.poll();
		
		PriorityQueue<String> q = new PriorityQueue<>();
		q.add(solve(l + 1, r));
		q.add(solve(l, r - 1));
		q.add(solve(l + 1, r - 1));
		dp[l][r] = q.poll();
		return dp[l][r];
	}
}