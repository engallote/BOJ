import java.util.*;
 
public class Main {
    static int N, M, res, hlen, clen;
    static int[][] arr;
    static boolean[] chk;
    static int[] dx = {0, -1, 0, 1}, dy = {1, 0, -1, 0};
    static ArrayList<Pair> h = new ArrayList<>(), c = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[N][N];
        res = Integer.MAX_VALUE;
        for(int i = 0; i < N; i++)
        	for(int j = 0; j < N; j++)
        	{
        		arr[i][j] = sc.nextInt();
        		if(arr[i][j] == 2)
        			c.add(new Pair(i, j));
        		else if(arr[i][j] == 1)
        			h.add(new Pair(i, j));
        	}
        hlen = h.size();
        clen = c.size();
        chk = new boolean[clen];
        solve(0, 0);
        System.out.println(res);
    }
	private static void solve(int idx, int cnt) {
		if(cnt == M)
		{
			res = Math.min(res, sum());
			return;
		}
		if(idx == clen) return;
		chk[idx] = true;
		solve(idx + 1, cnt + 1);
		chk[idx] = false;
		solve(idx + 1, cnt);
	}
	private static int sum() {
		int min, sum = 0;
		for(int i = 0; i < hlen; i++)
		{
			min = Integer.MAX_VALUE;
			for(int j = 0; j < clen; j++)
				if(chk[j])
					min = Math.min(min, Math.abs(h.get(i).x - c.get(j).x) + Math.abs(h.get(i).y - c.get(j).y));
			sum += min;
		}
		return sum;
	}
}
class Pair{
	int x, y;
	Pair(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
}