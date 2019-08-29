import java.util.*;

public class Main {
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		int s = sc.nextInt();
		char[] n = sc.next().toCharArray();
		int h = 2 * s + 3, w = s + 2, mid = h / 2;
		char[][][] arr = new char[10][h][w];
		for(int i = 0; i < 10; i++)
			for(int j = 0; j < h; j++)
				for(int k = 0; k < w; k++)
					arr[i][j][k] = ' ';
		///////////////////////////////////////////////////////////////////
		/////////////////////////////////////////    1
		for(int i = 1; i < h - 1; i++)
		{
			if(i == mid)
				continue;
			else
				arr[1][i][w-1] = '|';
		}
		/////////////////////////////////////////    2
		for(int i = 1; i < w-1; i++)
			arr[2][0][i] = '-';
		for(int i = 1; i < w-1; i++)
			arr[2][mid][i] = '-';
		for(int i = 1; i < w-1; i++)
			arr[2][h-1][i] = '-';
		
		for(int i = 1; i < h - 1; i++)
		{
			if(i == mid)
				continue;
			else if(i > mid)
				arr[2][i][0] = '|';
			
			else
				arr[2][i][w - 1] = '|';
		}
		/////////////////////////////////////////    3
		for(int i = 1; i < w-1; i++)
			arr[3][0][i] = '-';
		for(int i = 1; i < w-1; i++)
			arr[3][mid][i] = '-';
		for(int i = 1; i < w-1; i++)
			arr[3][h-1][i] = '-';
		
		for(int i = 1; i < h - 1; i++)
		{
			if(i == mid)
				continue;
			else
				arr[3][i][w - 1] = '|';
		}
		/////////////////////////////////////////    4
		for(int i = 1; i < h-1; i++)
		{
			if(i == mid)
			{
				for(int j = 1; j < w - 1; j++)
					arr[4][i][j] = '-';
			}
			else if(i > mid)
				arr[4][i][w - 1] = '|';
			else
			{
				arr[4][i][0] = '|';
				arr[4][i][w - 1] = '|';
			}
		}
		/////////////////////////////////////////    5
		for(int i = 1; i < w-1; i++)
			arr[5][0][i] = '-';
		for(int i = 1; i < w-1; i++)
			arr[5][mid][i] = '-';
		for(int i = 1; i < w-1; i++)
			arr[5][h-1][i] = '-';
		
		for(int i = 1; i < h - 1; i++)
		{
			if(i == mid)
				continue;
			else if(i > mid)
				arr[5][i][w - 1] = '|';
			
			else
				arr[5][i][0] = '|';
		}
		/////////////////////////////////////////    6
		for(int i = 1; i < w-1; i++)
			arr[6][0][i] = '-';
		for(int i = 1; i < w-1; i++)
			arr[6][mid][i] = '-';
		for(int i = 1; i < w-1; i++)
			arr[6][h-1][i] = '-';
		
		for(int i = 1; i < h - 1; i++)
		{
			if(i == mid)
				continue;
			else if(i > mid)
			{
				arr[6][i][0] = '|';
				arr[6][i][w - 1] = '|';
			}
			else
				arr[6][i][0] = '|';
		}
		/////////////////////////////////////////    7
		for(int i = 0; i < h - 1; i++)
		{
			if(i == 0)
				for(int j = 1; j < w - 1; j++)
					arr[7][i][j] = '-';
			else if(i == mid)
				continue;
			else
				arr[7][i][w - 1] = '|';
		}
		/////////////////////////////////////////    8
		for(int i = 1; i < w-1; i++)
			arr[8][0][i] = '-';
		for(int i = 1; i < w-1; i++)
			arr[8][mid][i] = '-';
		for(int i = 1; i < w-1; i++)
			arr[8][h-1][i] = '-';
		
		for(int i = 1; i < h - 1; i++)
		{
			if(i == mid)
				continue;
			else
			{
				arr[8][i][0] = '|';
				arr[8][i][w - 1] = '|';
			}
		}
		/////////////////////////////////////////    9
		for(int i = 1; i < w-1; i++)
			arr[9][0][i] = '-';
		for(int i = 1; i < w-1; i++)
			arr[9][mid][i] = '-';
		for(int i = 1; i < w-1; i++)
			arr[9][h-1][i] = '-';
		
		for(int i = 1; i < h - 1; i++)
		{
			if(i == mid)
				continue;
			else if(i > mid)
				arr[9][i][w - 1] = '|';
			
			else
			{
				arr[9][i][0] = '|';
				arr[9][i][w - 1] = '|';
			}
		}
		/////////////////////////////////////////    0
		for(int i = 1; i < w-1; i++)
			arr[0][0][i] = '-';
		for(int i = 1; i < w-1; i++)
			arr[0][h-1][i] = '-';
		
		for(int i = 1; i < h - 1; i++)
		{
			if(i == mid)
				continue;
			else
			{
				arr[0][i][0] = '|';
				arr[0][i][w - 1] = '|';
			}
		}
		///////////////////////////////////////////////////////////////////
		
		for(int i = 0; i < h; i++)
		{
			for(int j = 0; j < n.length; j++)
			{
				int num = n[j] - '0';
				for(int k = 0; k < w; k++)
					System.out.print(arr[num][i][k]);
				System.out.print(" ");
			}
			System.out.println();
		}		
	}
}