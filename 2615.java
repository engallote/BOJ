import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int x = 0, y = 0;
	static int[][] arr = new int[4][3];//1은 검은돌, 2는 흰돌
	static int[][] map = new int[20][20];
	static boolean[][] visit = new boolean[20][20];
	public static void main(String[] args) throws IOException {
//		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str;
		for(int i = 1; i < 20; i++)
		{
			str = br.readLine().split(" ");
			for(int j = 1; j < 20; j++)
				map[i][j] = Integer.parseInt(str[j-1]);
		}
		int cnt = 0, flag = 0;
		for(int i = 1; i < 20; i++)
		{
			for(int j = 1; j < 20; j++)
			{
				if(map[i][j] == 0) continue;
				if(right(i, j, map[i][j]))
				{
					System.out.println(map[i][j]);
					System.out.println(i + " " + j);
					return;
				}
				if(down(i, j, map[i][j]))
				{
					System.out.println(map[i][j]);
					System.out.println(i + " " + j);
					return;
				}
				if(rightDiagonalLine(i, j, map[i][j]))
				{
					System.out.println(map[i][j]);
					System.out.println(i + " " + j);
					return;
				}
				if(leftDiagonalLine(i, j, map[i][j]))
				{
//					System.out.println(">>" + i + " " + j);
					System.out.println(map[i][j]);
					System.out.println(x + " " + y);
					return;
				}
			}
		}
		System.out.println(0);
	}

	private static boolean leftDiagonalLine(int i, int j, int num) {
		int cnt = 0, tmpx = i-1, tmpy = j+1;
		while(i <= 19 && j >= 0)
		{
			if(map[i][j] == num) cnt++;
			else break;
			i++;
			j--;
		}
		while(tmpx >= 0 && tmpy <= 19)
		{
			if(map[tmpx][tmpy] == num) cnt++;
			else break;
			tmpx--;
			tmpy++;
		}
		if(cnt == 5)
		{
			x = i-1;
			y = j+1;
			return true;
		}
		else return false;
	}

	private static boolean rightDiagonalLine(int i, int j, int num) {
		int cnt = 0, tmpx = i-1, tmpy = j-1;
		while(i <= 19 && j <= 19)
		{
			if(map[i][j] == num) cnt++;
			else break;
			i++;
			j++;
		}
		while(tmpx >= 0 && tmpy >= 0)
		{
			if(map[tmpx][tmpy] == num) cnt++;
			else break;
			tmpx--;
			tmpy--;
		}
		if(cnt == 5) return true;
		else return false;
	}

	private static boolean down(int i, int j, int num) {
		int cnt = 0, tmpx = i - 1;
		for(; i <= 19; i++)
		{
			if(map[i][j] == num)
				cnt++;
			else
				break;
		}
		for(; tmpx >= 0; tmpx--)
		{
			if(map[tmpx][j] == num)
				cnt++;
			else break;
		}
		if(cnt == 5) return true;
		else return false;
	}

	private static boolean right(int i, int j, int num) {
		int cnt = 0, tmpy = j - 1;
		for(; j <= 19; j++)
		{
			if(map[i][j] == num)
				cnt++;
			else
				break;
		}
		for(; tmpy >= 0; tmpy--)
		{
			if(map[i][tmpy] == num)
				cnt++;
			else break;
		}
		if(cnt == 5) return true;
		else return false;
	}
}