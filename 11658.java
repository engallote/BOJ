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
		String[] str = br.readLine().split(" ");
		int N = Integer.parseInt(str[0]);
		int M = Integer.parseInt(str[1]);
		int[][] map = new int[N][N], sum = new int[N][N];
		
		for(int i = 0; i < N; i++)
		{
			str = br.readLine().split(" ");
			for(int j = 0; j < N; j++)
			{
				map[i][j] = Integer.parseInt(str[j]);
				if(j == 0)
					sum[i][j] = map[i][j];
				else
					sum[i][j] = map[i][j] + sum[i][j-1];
			}
		}
		
		for(int t = 0; t < M; t++)
		{
			str = br.readLine().split(" ");
			if(str[0].equals("0"))
			{
				int x = Integer.parseInt(str[1])-1;
				int y = Integer.parseInt(str[2])-1;
				int c = Integer.parseInt(str[3]);
				map[x][y] = c;
				
				for(int i = y; i < N; i++)
				{
					if(i == 0)
						sum[x][i] = map[x][i];
					else
						sum[x][i] = map[x][i] + sum[x][i-1];
				}
			}
			else
			{
				int x1 = Integer.parseInt(str[1])-1;
				int y1 = Integer.parseInt(str[2])-1;
				int x2 = Integer.parseInt(str[3])-1;
				int y2 = Integer.parseInt(str[4])-1;
				int res = 0;
				for(int i = x1; i <= x2; i++)
					res += sum[i][y2];
				
				if(y1 > 0)
					for(int i = x1; i <= x2; i++)
						res -= sum[i][y1-1];	
				bw.write(res+"\n");
			}
		}
		bw.flush();
	} 
}