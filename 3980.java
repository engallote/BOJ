import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
	static int res = 0;
	static int[][] arr;
	static boolean[] chk;
	public static void main(String[] args) throws IOException {
		// Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int tc = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= tc; test_case++)
		{
			res = 0;
			arr = new int[11][11];
			chk = new boolean[11];
			StringTokenizer st;
			for(int i = 0; i < 11; i++)
			{
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < 11; j++)
					arr[i][j] = Integer.parseInt(st.nextToken());
			}
			
			solve(0, 0);
			bw.write(res+"\n");
		}
		
		bw.flush();
	}
	private static void solve(int idx, int sum) {
		if(idx == 11)
		{
			res = Math.max(res, sum);
			return;
		}
		
		for(int i = 0; i < 11; i++)
			if(!chk[i] && arr[idx][i] > 0)
			{
				chk[i] = true;
				solve(idx + 1, sum + arr[idx][i]);
				chk[i] = false;
			}
	}
}