import java.util.*;

public class Main {
	static int N, M;
	static Vector<String> res = new Vector<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt()-1;
		Vector<Integer> v = new Vector<>();
		
		solve(0, v);
		
		if(res.size() <= M)
			System.out.println(-1);
		else
			System.out.println(res.get(M));
	}
	private static void solve(int sum, Vector<Integer> v) {
		if(sum == N)
		{
			String s = "";
			for(int i = 0; i < v.size(); i++)
			{
				if(i == v.size()-1)
					s += v.get(i);
				else
					s += v.get(i) + "+";
			}
			if(!res.contains(s))
				res.add(s);
			return;
		}
		if(sum + 1 <= N)
		{
			v.add(1);
			solve(sum + 1, v);
			v.remove(v.size()-1);
		}
		if(sum + 2 <= N)
		{
			v.add(2);
			solve(sum + 2, v);
			v.remove(v.size()-1);
		}
		if(sum + 3 <= N)
		{
			v.add(3);
			solve(sum + 3, v);
			v.remove(v.size()-1);
		}
	}
}