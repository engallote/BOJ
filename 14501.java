import java.util.*;
 
public class Main {
    static int N, res = 0;
    static int[][] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new int[N][2];
        
        for(int i = 0; i < N; i++)
        {
        	arr[i][0] = sc.nextInt();
        	arr[i][1] = sc.nextInt();
        }
        
        for(int i = 0; i < N; i++)
        	if(i + arr[i][0] <= N)
        	{
//        		System.out.println("start => " + (i+1) + "¹øÂ° ³¯");
        		solve(i + arr[i][0], arr[i][1]);
        	}
        System.out.println(res);
    }
	private static void solve(int cur, int sum) {
		res = Math.max(res, sum);
		if(cur >= N) return;
		
		for(int i = cur; i < N; i++)
			if(i + arr[i][0] <= N)
				solve(i + arr[i][0], sum + arr[i][1]);
	}
}