import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);			
		char[] c = sc.next().toCharArray();
		int len = c.length;
		int R = 0, C = 0;
		for(int i = 1; i <= len / 2; i++)
			for(int j = len; j >= i; j--)
				if(i * j == len && R < i)
				{
					R = i;
					C = j;
				}
//		System.out.println(R + " " + C);
		char[][] map = new char[R][C];
		
		int idx = 0;
		for(int i = 0; i < C; i++)
			for(int j = 0; j < R; j++)
			{
				map[j][i] = c[idx];
				idx++;
			}
		
		for(int i = 0; i < R; i++)
			for(int j = 0; j < C; j++)
				System.out.print(map[i][j]);
	}
}