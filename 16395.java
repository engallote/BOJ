import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] arr = new int[31][31];
		int N = sc.nextInt();
		int K = sc.nextInt();
		int len = 2;
		for(int i = 1; i <= 30; i++)
		{
			Arrays.fill(arr[i], 1);
			if(i >= 3)
			{
				for(int j = 2; j <= len; j++)
					arr[i][j] = arr[i-1][j-1] + arr[i-1][j];
				len++;
			}
		}
		
		System.out.println(arr[N][K]);
	}
}