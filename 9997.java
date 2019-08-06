import java.util.*;
 
public class Main {
	static int N, res;
	static int[] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new int[N];
        res = 0;
        for(int i = 0; i < N; i++)
        {
        	String str = sc.next();
        	int visit = 0;
        	for(char c : str.toCharArray())
        		if((visit&(1<<(c-'a'))) == 0) visit|=(1<<(c-'a'));
        	arr[i] = visit;
        }
        
        solve(0, 0);
        System.out.println(res);
    }
	private static void solve(int idx, int visit) {
		if(idx == N) 
		{
			if(visit == (1<<26) - 1)
				res++;
			return;
		}
		solve(idx + 1, visit | arr[idx]);
		solve(idx + 1, visit);
	}
}