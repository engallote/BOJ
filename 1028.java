import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
	static int N, M, res;
	static int[][] arr;
	public static void main(String[] args) throws IOException {
//        Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        res = 0;
        for(int i = 0; i < N; i++)
        {
        	char[] c = br.readLine().toCharArray();
        	for(int j = 0; j < M; j++)
        	{
        		arr[i][j] = c[j] - '0';
        		if(arr[i][j] == 1) res = 1;
        	}
        }
        
        for(int i = 0; i < N-1; i++)
        	for(int j = 1; j < M-1; j++)
        		if(arr[i][j] == 1) solve(i, j);
        
        bw.write(res+"");
        bw.flush();
//        System.out.println(res);
    }
	private static void solve(int x, int y) {
		int l = y-1, r = y+1, row = x+1;
		int k = 0;
		
		while(l >= 0 && r < M && row < N)
		{
			if(arr[row][l] == 0 || arr[row][r] == 0) break;
			k++;
			if(row + k - 1 >= N) break;
			row++;
			l--;
			r++;
		}
		if(res > k+1) return;
		for(; k > 0; k--)
			if(find(x + k, y - k, y + k))
			{
				res = Math.max(res, k+1);
				break;
			}
	}
	private static boolean find(int row, int l, int r) {
		if(l < 0 || r >= M || row >= N) return false;
		while(l <= r)
		{
			if(arr[row][l] == 0 || arr[row][r] == 0) return false;
			row++;
			if(row == N) break;
			l++;
			r--;
		}
		if(l < r) return false;
		else return true;
	}
}