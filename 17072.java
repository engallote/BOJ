import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		StringBuilder str = new StringBuilder();
		for(int i = 0; i < N; i++)
		{
			for(int j = 0; j < M; j++)
			{
				int r = sc.nextInt() * 2126;
				int g = sc.nextInt() * 7152;
				int b = sc.nextInt() * 722;
				str.append(Intensity(r + g + b));
			}
			if(i != N-1)
				str.append("\n");
		}
		System.out.println(str.toString());
	}

	private static char Intensity(int num) {
		if(num < 510000) return '#';
		else if(num < 1020000) return 'o';
		else if(num < 1530000) return '+';
		else if(num < 2040000) return '-';
		return '.';
	}
}