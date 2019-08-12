import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[][] arr = new int[N][M];
		ArrayList<Pair> aly = new ArrayList<>();
		for(int i = 0; i < N; i++)
			for(int j = 0; j < M; j++)
			{
				arr[i][j] = sc.nextInt();
				if(arr[i][j] == 1) aly.add(new Pair(i, j));
			}
		
		int res = Math.abs(aly.get(0).x - aly.get(1).x) + Math.abs(aly.get(0).y - aly.get(1).y);
		System.out.println(res);
	}
}
class Pair{
	int x, y;
	Pair(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
}