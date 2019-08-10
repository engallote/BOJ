import java.util.*;

public class Main {
	static int N;
	static char[] order;
	static boolean[] visit;
	static Vector<String> v = new Vector<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		order = new char[N];
		for(int i = 0; i < N; i++)
			order[i] = sc.next().charAt(0);
		visit = new boolean[10];
		
		
		for(int i = 0; i <= 9; i++)
		{
			Arrays.fill(visit, false);
			visit[i] = true;
			solve(0, i+"");
		}
		
		System.out.println(v.get(v.size()-1));
		System.out.println(v.get(0));
	}
	private static void solve(int idx, String s) {
		if(idx == N)
		{
			v.addElement(s);
			return;
		}
		
		for(int i = 0; i <= 9; i++)
		{
			if(visit[i]) continue;
			if(order[idx] == '>')
			{
				if(s.charAt(s.length() - 1) - '0' > i)
				{
					visit[i] = true;
					solve(idx + 1, s + i);
					visit[i] = false;
				}
			}
			if(order[idx] == '<')
			{
				if(s.charAt(s.length() - 1) - '0' < i)
				{
					visit[i] = true;
					solve(idx + 1, s + i);
					visit[i] = false;
				}
			}
		}
	}
}