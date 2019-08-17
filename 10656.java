import java.util.*;

public class Main {
	static int N, M;
	static char[][] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new char[N][M];
		Queue<Pair> q = new LinkedList<>();
		for(int i = 0; i < N; i++)
			arr[i] = sc.next().toCharArray();
		
		for(int i = 0; i < N; i++)
		{
			for(int j = 0; j < M; j++)
			{
				if(arr[i][j] == '#') continue;
				if(i == 0 || (i > 0 && arr[i-1][j] == '#'))//세로 검사
				{
					int cnt = 0;
					for(int k = i; k < N; k++)
					{
						if(arr[k][j] == '#') break;
						cnt++;
					}
					if(cnt >= 3)
					{
						q.add(new Pair(i + 1, j + 1));
						continue;
					}
				}
				if(j == 0 || (j > 0 && arr[i][j-1] == '#'))//가로 검사
				{
					int cnt = 0;
					for(int k = j; k < M; k++)
					{
						if(arr[i][k] == '#') break;
						cnt++;
					}
					if(cnt >= 3)
						q.add(new Pair(i + 1, j + 1));
				}
			}
		}
		
		System.out.println(q.size());
		while(!q.isEmpty())
			System.out.println(q.peek().x + " " + q.poll().y);
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