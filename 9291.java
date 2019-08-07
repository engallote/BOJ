import java.util.*;

public class Main {
	static int[][] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			arr = new int[9][9];
			
			for(int i = 0; i < 9; i++)
				for(int j = 0; j < 9; j++)
					arr[i][j] = sc.nextInt();
			
			boolean b1 = checkVer();
			boolean b2 = checkHor();
			boolean b3 = check();
			if(b1 && b2 && b3) System.out.println("Case " + test_case + ": CORRECT");
			else System.out.println("Case " + test_case + ": INCORRECT");
		}
	}
	private static boolean check() {
		HashSet<Integer> hs = new HashSet<>();
		for(int i = 0; i < 3; i++)
		{
			for(int j = 0; j < 3; j++)
			{
				if(hs.contains(arr[i][j])) return false;
				hs.add(arr[i][j]);
			}
		}
		hs.clear();
		for(int i = 0; i < 3; i++)
		{
			for(int j = 3; j < 6; j++)
			{
				if(hs.contains(arr[i][j])) return false;
				hs.add(arr[i][j]);
			}
		}
		hs.clear();
		for(int i = 0; i < 3; i++)
		{
			for(int j = 6; j < 9; j++)
			{
				if(hs.contains(arr[i][j])) return false;
				hs.add(arr[i][j]);
			}
		}
		//////////////////
		hs.clear();
		for(int i = 3; i < 6; i++)
		{
			for(int j = 0; j < 3; j++)
			{
				if(hs.contains(arr[i][j])) return false;
				hs.add(arr[i][j]);
			}
		}
		hs.clear();
		for(int i = 3; i < 6; i++)
		{
			for(int j = 3; j < 6; j++)
			{
				if(hs.contains(arr[i][j])) return false;
				hs.add(arr[i][j]);
			}
		}
		hs.clear();
		for(int i = 3; i < 6; i++)
		{
			for(int j = 6; j < 9; j++)
			{
				if(hs.contains(arr[i][j])) return false;
				hs.add(arr[i][j]);
			}
		}
		//////////////////
		hs.clear();
		for(int i = 6; i < 9; i++)
		{
			for(int j = 0; j < 3; j++)
			{
				if(hs.contains(arr[i][j])) return false;
				hs.add(arr[i][j]);
			}
		}
		hs.clear();
		for(int i = 6; i < 9; i++)
		{
			for(int j = 3; j < 6; j++)
			{
				if(hs.contains(arr[i][j])) return false;
				hs.add(arr[i][j]);
			}
		}
		hs.clear();
		for(int i = 6; i < 9; i++)
		{
			for(int j = 6; j < 9; j++)
			{
				if(hs.contains(arr[i][j])) return false;
				hs.add(arr[i][j]);
			}
		}
		return true;
	}
	private static boolean checkHor() {
		HashSet<Integer> hs = new HashSet<>();
		for(int i = 0; i < 9; i++){
			hs.clear();
			for(int j = 0; j < 9; j++)
			{
				if(hs.contains(arr[j][i])) return false;
				hs.add(arr[j][i]);
			}
		}
		return true;
	}
	private static boolean checkVer() {
		HashSet<Integer> hs = new HashSet<>();
		for(int i = 0; i < 9; i++){
			hs.clear();
			for(int j = 0; j < 9; j++)
			{
				if(hs.contains(arr[i][j])) return false;
				hs.add(arr[i][j]);			
			}
		}
		return true;
	}
}