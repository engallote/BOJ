import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[][][] num = new char[10][7][5];
		for(int i = 0; i < 10; i++)
			make(i, num);
		
//		for(int k = 0; k < 10; k++)
//		{
//			for(int i = 0; i < 7; i++)
//			{
//				for(int j = 0; j < 5; j++)
//					System.out.print(num[k][i][j]);
//				System.out.println();
//			}
//			System.out.println("-----");
//		}
		
		char[][] arr = new char[7][];
		for(int i = 0; i < 7; i++) arr[i] = sc.next().toCharArray();
		int len = arr[0].length, res = 0, sum = 0;
		boolean flag;
		for(int c = 0; c < len; c+=6)
		{
			flag = true;
			int idx = c;
			for(int n = 0; n < 10; n++)
			{
				flag = true;
				for(int i = 0; i < 7; i++)
				{
					idx = c;
					for(int j = 0; j < 5; j++)
					{
						if(num[n][i][j] == arr[i][idx]) idx++;
						else
						{
							flag = false;
							break;
						}
					}
					if(!flag) break;
				}
				if(flag)
				{
					sum *= 10;
					sum += n;
					break;
				}
			}
			if(!flag)
			{
				res += sum;
				sum = 0;
			}
		}
		res += sum;
		char[] ch = Integer.toString(res).toCharArray();
		ArrayList<Character>[] aly = new ArrayList[7];
		for(int i = 0; i < 7; i++) aly[i] = new ArrayList<>();
		for(char c : ch)
		{
			for(int i = 0; i < 7; i++)
				for(int j = 0; j < 6; j++)
				{
					if(j == 5)
					{
						aly[i].add('.');
						break;
					}
					aly[i].add(num[c-'0'][i][j]);
				}
		}
		
		for(int i = 0; i < 7; i++)
		{
			for(int j = 0; j < aly[i].size() - 1; j++)
			{
				System.out.print(aly[i].get(j));
			}
			System.out.println();
		}
	}

	private static void make(int idx, char[][][] num) {
		if(idx == 0)
		{
			for(int i = 0; i < 7; i++)
			{
				Arrays.fill(num[idx][i], 'x');
				if(i > 0 && i < 6)
					for(int j = 1; j < 4; j++) num[idx][i][j] = '.';
			}
		}
		else if(idx == 1)
		{
			for(int i = 0; i < 7; i++)
			{
				Arrays.fill(num[idx][i], '.');
				num[idx][i][4] = 'x';
			}
		}
		else if(idx == 2)
		{
			for(int i = 0; i < 7; i++)
			{
				Arrays.fill(num[idx][i], 'x');
				if(i == 1 || i == 2)
					for(int j = 0; j < 4; j++) num[idx][i][j] = '.';
				else if(i == 4 || i == 5)
					for(int j = 1; j < 5; j++) num[idx][i][j] = '.';
			}
		}
		else if(idx == 3)
		{
			for(int i = 0; i < 7; i++)
			{
				Arrays.fill(num[idx][i], 'x');
				if(i == 1 || i == 2 || i == 4 || i == 5)
					for(int j = 0; j < 4; j++) num[idx][i][j] = '.';
			}
		}
		else if(idx == 4)
		{
			for(int i = 0; i < 7; i++)
			{
				Arrays.fill(num[idx][i], 'x');
				if(i >= 0 && i < 3)
					for(int j = 1; j < 4; j++) num[idx][i][j] = '.';
				else if(i > 3)
					for(int j = 0; j < 4; j++) num[idx][i][j] = '.';
			}
		}
		else if(idx == 5)
		{
			for(int i = 0; i < 7; i++)
			{
				Arrays.fill(num[idx][i], 'x');
				if(i == 1 || i == 2)
					for(int j = 1; j < 5; j++) num[idx][i][j] = '.';
				else if(i == 4 || i == 5)
					for(int j = 0; j < 4; j++) num[idx][i][j] = '.';
			}
		}
		else if(idx == 6)
		{
			for(int i = 0; i < 7; i++)
			{
				Arrays.fill(num[idx][i], 'x');
				if(i == 1 || i == 2)
					for(int j = 1; j < 5; j++) num[idx][i][j] = '.';
				else if(i == 4 || i == 5)
					for(int j = 1; j < 4; j++) num[idx][i][j] = '.';
			}
		}
		else if(idx == 7)
		{
			Arrays.fill(num[idx][0], 'x');
			for(int i = 1; i < 7; i++)
			{
				for(int j = 0; j < 4; j++) num[idx][i][j] = '.';
				num[idx][i][4] = 'x';
			}
		}
		else if(idx == 8)
		{
			for(int i = 0; i < 7; i++)
			{
				Arrays.fill(num[idx][i], 'x');
				if(i == 1 || i == 2 || i == 4 || i == 5)
					for(int j = 1; j < 4; j++) num[idx][i][j] = '.';
			}
		}
		else if(idx == 9)
		{
			for(int i = 0; i < 7; i++)
			{
				Arrays.fill(num[idx][i], 'x');
				if(i == 1 || i == 2)
					for(int j = 1; j < 4; j++) num[idx][i][j] = '.';
				else if(i == 4 || i == 5)
					for(int j = 0; j < 4; j++) num[idx][i][j] = '.';
			}
		}
	}
}