import java.util.*;

public class Main {
	static boolean flag = false;
	static int[][] arr = new int[9][9];
	static boolean[][] visit;
	static ArrayList<Pair> aly = new ArrayList<>();
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i < 9; i++)
        {
        	char[] c = sc.next().toCharArray();
        	for(int j = 0; j < 9; j++)
        	{
        		arr[i][j] = c[j] - '0';
        		if(arr[i][j] == 0)
        			aly.add(new Pair(i, j));
        	}
        }
        
        dfs(0);
    }
	private static void dfs(int idx) {
		if(flag) return;
		if(idx == aly.size())
		{
			flag = true;
			for(int i = 0; i < 9; i++)
			{
				for(int j = 0; j < 9; j++)
					System.out.print(arr[i][j]);
				System.out.println();
			}
			return;
		}
		
		for(int i = 1; i <= 9; i++)
		{
			int x = aly.get(idx).x;
			int y = aly.get(idx).y;
			arr[x][y] = i;
			if(sudoku(x, y))
				dfs(idx + 1);	
			arr[x][y] = 0;
		}
	}
	private static boolean sudoku(int x, int y) {
		HashSet<Integer> hs = new HashSet<>();
		for(int i = 0; i < 9; i++)
		{
			if(arr[x][i] == 0) continue;
			if(hs.contains(arr[x][i])) return false;
			hs.add(arr[x][i]);
		}
		hs.clear();
		for(int i = 0; i < 9; i++)
		{
			if(arr[i][y] == 0) continue;
			if(hs.contains(arr[i][y])) return false;
			hs.add(arr[i][y]);
		}
		
		hs.clear();
		if(x >= 0 && x < 3)
		{
			if(y >= 0 && y < 3)
			{
				for(int i = 0; i < 3; i++)
					for(int j = 0; j < 3; j++)
					{
						if(arr[i][j] == 0) continue;
						if(hs.contains(arr[i][j])) return false;
						hs.add(arr[i][j]);
					}
			}
			else if(y >= 3 && y < 6)
			{
				for(int i = 0; i < 3; i++)
					for(int j = 3; j < 6; j++)
					{
						if(arr[i][j] == 0) continue;
						if(hs.contains(arr[i][j])) return false;
						hs.add(arr[i][j]);
					}
			}
			else
			{
				for(int i = 0; i < 3; i++)
					for(int j = 6; j < 9; j++)
					{
						if(arr[i][j] == 0) continue;
						if(hs.contains(arr[i][j])) return false;
						hs.add(arr[i][j]);
					}
			}
		}
		else if(x >= 3 && x < 6)
		{
			if(y >= 0 && y < 3)
			{
				for(int i = 3; i < 6; i++)
					for(int j = 0; j < 3; j++)
					{
						if(arr[i][j] == 0) continue;
						if(hs.contains(arr[i][j])) return false;
						hs.add(arr[i][j]);
					}
			}
			else if(y >= 3 && y < 6)
			{
				for(int i = 3; i < 6; i++)
					for(int j = 3; j < 6; j++)
					{
						if(arr[i][j] == 0) continue;
						if(hs.contains(arr[i][j])) return false;
						hs.add(arr[i][j]);
					}
			}
			else
			{
				for(int i = 3; i < 6; i++)
					for(int j = 6; j < 9; j++)
					{
						if(arr[i][j] == 0) continue;
						if(hs.contains(arr[i][j])) return false;
						hs.add(arr[i][j]);
					}
			}
		}
		else
		{
			if(y >= 0 && y < 3)
			{
				for(int i = 6; i < 9; i++)
					for(int j = 0; j < 3; j++)
					{
						if(arr[i][j] == 0) continue;
						if(hs.contains(arr[i][j])) return false;
						hs.add(arr[i][j]);
					}
			}
			else if(y >= 3 && y < 6)
			{
				for(int i = 6; i < 9; i++)
					for(int j = 3; j < 6; j++)
					{
						if(arr[i][j] == 0) continue;
						if(hs.contains(arr[i][j])) return false;
						hs.add(arr[i][j]);
					}
			}
			else
			{
				for(int i = 6; i < 9; i++)
					for(int j = 6; j < 9; j++)
					{
						if(arr[i][j] == 0) continue;
						if(hs.contains(arr[i][j])) return false;
						hs.add(arr[i][j]);
					}
			}
		}
		return true;
	}
}
class Pair{
	int x, y;
	Pair(int x, int y){
		this.x = x;
		this.y = y;
	}
}