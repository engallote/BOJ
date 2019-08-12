import java.util.*;

public class Main {
	static int N, sx, sy, ex, ey;
	static boolean end;
	static boolean[][] chk;
	static Pair[] arr;
	static HashSet<Integer> hs = new HashSet<>();
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        
        for(int test_case = 1; test_case <= tc; test_case++)
        {
        	end = false;
        	N = sc.nextInt() + 2;
        	arr = new Pair[N];
        	chk = new boolean[N][N];
        	arr[0] = new Pair(sx, sy);
        	for(int i = 0; i < N; i++)
        		arr[i] = new Pair(sc.nextInt(), sc.nextInt());
        	
        	for(int i = 0; i < N; i++)
        	{
        		chk[i][i] = true;
        		for(int j = i + 1; j < N; j++)
        		{
        			int d = Math.abs(arr[i].x - arr[j].x) + Math.abs(arr[i].y - arr[j].y);
        			if(d <= 1000)
        				chk[i][j] = chk[j][i] = true;
        		}
        	}
        	
        	for(int k = 0; k < N; k++)
        		for(int i = 0; i < N; i++)
        			for(int j = 0; j < N; j++)
        				if(chk[i][k] && chk[k][j]) chk[i][j] = true;
        	
        	if(chk[0][N-1]) System.out.println("happy");
        	else System.out.println("sad");
        }
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