import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
//		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][N];
		int[][] sum = new int[N][N];
		for(int i = 0; i < N; i++)
		{
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++)
				arr[i][j] = Integer.parseInt(st.nextToken());
		}
		
		int max = 0, min = Integer.MAX_VALUE;
		int x = 0, y = 0;
		while(true)
		{
			max = 0;
			min = Integer.MAX_VALUE;
			for(int i = x; i < x + B; i++)
				for(int j = y; j < y + B; j++)
				{
					if(min > arr[i][j])
						min = arr[i][j];
					if(max < arr[i][j])
						max = arr[i][j];
				}
			sum[x][y] = max - min;
			y++;
			if(y + B > N)
			{
				y = 0;
				x++;
			}
			if(x + B > N) break;
		}
		
		for(int i = 0; i < K; i++)
		{
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken()) - 1;
			y = Integer.parseInt(st.nextToken()) - 1;
			System.out.println(sum[x][y]);
		}
	}
}