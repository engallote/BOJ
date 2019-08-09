import java.util.*;

public class Main {
	static char[][][] ch = new char[10][5][3];
	static char[][] zero = {{'#','#','#'},{'#','.','#'},{'#','.','#'},{'#','.','#'},{'#','#','#'}};
	static char[][] one = {{'.','.','#'},{'.','.','#'},{'.','.','#'},{'.','.','#'},{'.','.','#'}};
	static char[][] two = {{'#','#','#'},{'.','.','#'},{'#','#','#'},{'#','.','.'},{'#','#','#'}};
	static char[][] three = {{'#','#','#'},{'.','.','#'},{'#','#','#'},{'.','.','#'},{'#','#','#'}};
	static char[][] four = {{'#','.','#'},{'#','.','#'},{'#','#','#'},{'.','.','#'},{'.','.','#'}};
	static char[][] five = {{'#','#','#'},{'#','.','.'},{'#','#','#'},{'.','.','#'},{'#','#','#'}};
	static char[][] six = {{'#','#','#'},{'#','.','.'},{'#','#','#'},{'#','.','#'},{'#','#','#'}};
	static char[][] seven = {{'#','#','#'},{'.','.','#'},{'.','.','#'},{'.','.','#'},{'.','.','#'}};
	static char[][] eight = {{'#','#','#'},{'#','.','#'},{'#','#','#'},{'#','.','#'},{'#','#','#'}};
	static char[][] nine = {{'#','#','#'},{'#','.','#'},{'#','#','#'},{'.','.','#'},{'#','#','#'}};
	static StringBuilder ans = new StringBuilder();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ch[0] = zero;
		ch[1] = one;
		ch[2] = two;
		ch[3] = three;
		ch[4] = four;
		ch[5] = five;
		ch[6] = six;
		ch[7] = seven;
		ch[8] = eight;
		ch[9] = nine;
		String[] str = new String[5];
		for(int i = 0; i < 5; i++)
			str[i] = sc.nextLine();
		
		int st = 0, ed = 3;
		
		for(int t = 0; t < 4; t++)
		{
			char[][] map = new char[5][3];
			int idx = 0;
			for(int i = 0; i < 5; i++)
			{
				for(int j = st; j < ed; j++)
				{
					map[i][idx] = str[i].charAt(j);
					idx++;
				}
				idx = 0;
			}
			
			st = ed + 1;
			ed = st + 3;
			find(map);
		}
		System.out.println(ans.toString());
	}
	private static void find(char[][] map) {
		int max = 0, num = 0;
		int[] arr = new int[10];
		
		for(int i = 0; i < 10; i++)
		{
			int cnt = 0;
			boolean f = true;
			for(int k = 0; k < 5; k++)
			{
				for(int s = 0; s < 3; s++)
				{
					if(map[k][s] == '#' && ch[i][k][s] == '.')
					{
						f = false;
						break;
					}
					else
						cnt++;
				}
				if(!f)
				{
					arr[i] = 0;
					break;
				}
			}
			arr[i] = cnt;
			if(max < cnt)
			{
				max = cnt;
				num = i;
			}
		}

		if(ans.toString().length() == 0 && num >= 6)
		{
			while(ans.length() < 1)
			{
				for(int i = 0; i < 6; i++)
				{
					if(max == arr[i])
					{
						boolean f = true;
						for(int k = 0; k < 5; k++)
						{
							for(int s = 0; s < 3; s++)
								if(map[k][s] == '#' && ch[i][k][s] == '.')
								{
									f = false;
									break;
								}
							if(!f)
								break;
						}
						if(f)
						{
							ans.append(i);
							break;
						}
					}
				}
				max--;
			}
			
		}
		else if(ans.toString().length() == 3 && num >= 6)
		{
			while(ans.length() < 4)
			{
				for(int i = 0; i < 6; i++)
				{
					if(max == arr[i])
					{
						boolean f = true;
						for(int k = 0; k < 5; k++)
						{
							for(int s = 0; s < 3; s++)
								if(map[k][s] == '#' && ch[i][k][s] == '.')
								{
									f = false;
									break;
								}
							if(!f)
								break;
						}
						if(f)
						{
							ans.append(i);
							break;
						}
					}
				}
				max--;
			}
			
		}
		else
			ans.append(num);
		if(ans.toString().length() == 2)
			ans.append(":");
	}
}
