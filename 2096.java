import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		long maxNum = 0, minNum = 0;
		int[][] arr = new int[N][3];
		
		for(int i = 0; i < N; i++)
			for(int j = 0; j < 3; j++)
				arr[i][j] = sc.nextInt();
		
		int[][] max = new int[N][3];
		int[][] min = new int[N][3];
		
		for(int j = 0; j < 3; j++)
			max[0][j] = min[0][j] = arr[0][j];
		
		for(int i = 1; i < N; i++)
		{
			max[i][0] = Math.max(max[i-1][0], max[i-1][1]) + arr[i][0];
			min[i][0] = Math.min(min[i-1][0], min[i-1][1]) + arr[i][0];
			
			max[i][1] = Math.max(max[i-1][0], Math.max(max[i-1][1], max[i-1][2])) + arr[i][1];
			min[i][1] = Math.min(min[i-1][0], Math.min(min[i-1][1], min[i-1][2])) + arr[i][1];
			
			max[i][2] = Math.max(max[i-1][2], max[i-1][1]) + arr[i][2];
			min[i][2] = Math.min(min[i-1][2], min[i-1][1]) + arr[i][2];
		}
		
		maxNum = Math.max(max[N-1][0], Math.max(max[N-1][1], max[N-1][2]));
		minNum = Math.min(min[N-1][0], Math.min(min[N-1][1], min[N-1][2]));
		System.out.println(maxNum + " " + minNum);
	}
}