import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		char[][] arr = new char[N][M], res = new char[M][N];
		
		for(int i = 0; i < N; i++)
			arr[i] = sc.next().toCharArray();
		
		HashMap<Character, Character> hs = new HashMap<>();
		hs.put('.', '.');
		hs.put('O', 'O');
		hs.put('-', '|');
		hs.put('|', '-');
		hs.put('/', '\\');
		hs.put('\\', '/');
		hs.put('^', '<');
		hs.put('<', 'v');
		hs.put('v', '>');
		hs.put('>', '^');
		
		int r = 0, c = 0;
		for(int i = 0; i < N; i++)
			for(int j = M-1; j >= 0; j--)
			{
				res[r][c] = hs.get(arr[i][j]);
				r++;
				if(r == M)
				{
					r = 0;
					c++;
				}
			}
		
		for(int i = 0; i < M; i++)
		{
			for(int j = 0; j < N; j++)
				System.out.print(res[i][j]);
			System.out.println();
		}
	}
}