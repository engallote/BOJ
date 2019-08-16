import java.util.*;

public class Main {
	static int N, res;
	static int[][] arr;
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new int[N][2];
        for(int i = 0 ; i < N; i++)
        {
        	arr[i][0] = sc.nextInt();
        	arr[i][1] = sc.nextInt();
        }
        res = 0;
        solve(0);
        System.out.println(res);
	}
	public static void solve(int idx){
		if(idx == N)
		{
			int cnt = 0;
			for(int i = 0; i < N; i++)
				if(arr[i][0] <= 0) cnt++;
			res = Math.max(res, cnt);
			return;
		}
		
		if(arr[idx][0] <= 0) solve(idx + 1);
		else
		{
			boolean next = false;
			for(int i = 0; i < N; i++)
				if(i != idx && arr[i][0] > 0 && arr[idx][0] > 0)
				{
					arr[i][0] -= arr[idx][1];
					arr[idx][0] -= arr[i][1];
					next = true;
					solve(idx + 1);
					
					arr[i][0] += arr[idx][1];
					arr[idx][0] += arr[i][1];
				}
			if(!next) solve(idx + 1);
		}		
	}
}