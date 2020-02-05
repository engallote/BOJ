import java.util.*;

public class Main {
	static boolean flag = false;
	static int[][] arr = new int[9][9];
	static boolean[][] visit;
	static ArrayList<Pair> aly = new ArrayList<>();
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i < 9; i++){
        	char[] c = sc.next().toCharArray();
        	for(int j = 0; j < 9; j++){
        		arr[i][j] = c[j] - '0';
        		if(arr[i][j] == 0)
        			aly.add(new Pair(i, j));
        	}
        }
        
        dfs(0);
    }
	private static void dfs(int idx) {
		if(flag) return;
		if(idx == aly.size()){
			flag = true;
			for(int i = 0; i < 9; i++){
				for(int j = 0; j < 9; j++)
					System.out.print(arr[i][j]);
				System.out.println();
			}
			return;
		}
		
		for(int i = 1; i <= 9; i++){
			int x = aly.get(idx).x;
			int y = aly.get(idx).y;
			if(sudoku(x, y, i)){
				arr[x][y] = i;
				dfs(idx + 1);
				arr[x][y] = 0;
			}
		}
	}
	private static boolean sudoku(int x, int y, int num) {
		for(int i = 0; i < 9; i++)//세로 가로 확인
			if(arr[x][i] == num || arr[i][y] == num) return false;
		
		int xx = x / 3 * 3, yy = y / 3 * 3;//구역 확인
		for(int i = xx; i < xx + 3; i++)
			for(int j = yy; j < yy + 3; j++)
				if(arr[i][j] == num) return false;
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
