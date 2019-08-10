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
		int N = Integer.parseInt(br.readLine());
		char[] order = br.readLine().toCharArray();
		char[][] map = new char[N][N];
		
		for(int i = 0; i < N; i++)
			Arrays.fill(map[i], '.');
		
		int x = 0, y = 0;
		
		for(int i = 0; i < order.length; i++)
		{
			switch(order[i])
			{
			case 'D':
				if(x + 1 < N)
				{
					if(map[x][y] == '-')
						map[x][y] = '+';
					else if(map[x][y] == '.')
						map[x][y] = '|';
					x++;
					if(map[x][y] == '-')
						map[x][y] = '+';
					else if(map[x][y] == '.')
						map[x][y] = '|';
				}
				break;
			case 'L':
				if(y - 1 >= 0)
				{
					if(map[x][y] == '|')
						map[x][y] = '+';
					else if(map[x][y] == '.')
						map[x][y] = '-';
					y--;
					if(map[x][y] == '|')
						map[x][y] = '+';
					else if(map[x][y] == '.')
						map[x][y] = '-';
				}
				break;
			case 'R':
				if(y + 1 < N)
				{
					if(map[x][y] == '|')
						map[x][y] = '+';
					else if(map[x][y] == '.')
						map[x][y] = '-';
					y++;
					if(map[x][y] == '|')
						map[x][y] = '+';
					else if(map[x][y] == '.')
						map[x][y] = '-';
				}
				break;
			case 'U':
				if(x - 1 >= 0)
				{
					if(map[x][y] == '-')
						map[x][y] = '+';
					else if(map[x][y] == '.')
						map[x][y] = '|';
					x--;
					if(map[x][y] == '-')
						map[x][y] = '+';
					else if(map[x][y] == '.')
						map[x][y] = '|';
				}
				break;
			}
		}
		
		for(int i = 0; i < N; i++)
		{
			for(int j = 0; j < N; j++)
				bw.write(map[i][j]);
			bw.write("\n");
		}
		bw.flush();
	}
}