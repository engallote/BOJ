import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int[][] arr = new int[M][M];
		
		for(int i = 0; i < M; i++)
			Arrays.fill(arr[i], 1);
		
		int[] num = new int[2 * M];
		for(int i = 0; i < N; i++)
		{
			st = new StringTokenizer(br.readLine());
			int zero = Integer.parseInt(st.nextToken());
			int one = Integer.parseInt(st.nextToken());
			int two = Integer.parseInt(st.nextToken());
			int idx = 0;
			while(idx < 2 * M - 1)
			{
				if(zero > 0)
				{
					zero--;
				}
				else if(one > 0)
				{
					num[idx] += 1;
					one--;
				}
				else
				{
					num[idx] += 2;
					two--;
				}
				idx++;
			}
		}
		int r = M - 1, col = 0;
		
		for(int i = 0; i < 2 * M - 1; i++)
		{
			if(r == 0)
			{
				arr[r][col] += num[i];
				col++;
			}
			else
			{
				arr[r][col] += num[i];
				r--;
			}
		}
		
		for(int i = 1; i < M; i++)
			for(int j = 1; j < M; j++)
				arr[i][j] = Math.max(arr[i-1][j], Math.max(arr[i][j-1], arr[i-1][j-1]));
		
		for(int i = 0; i < M; i++)
		{
			for(int j = 0; j < M; j++)
				bw.write(arr[i][j] + " ");
			bw.write("\n");
		}
		bw.flush();
	}
}