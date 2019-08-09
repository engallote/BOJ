import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		
		int N = sc.nextInt();
		int[][] arr = new int[N][4];
		int[] chk = new int[a+b+c+1];
		Arrays.fill(chk, 2);
		for(int i = 0; i < N; i++)
		{
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
			arr[i][2] = sc.nextInt();
			arr[i][3] = sc.nextInt();
			
			if(arr[i][3] == 1)
				chk[arr[i][0]] = chk[arr[i][1]] = chk[arr[i][2]] = 1;
		}
		
		for(int i = 0; i < N; i++)
		{
			int sum = 0;
			for(int j = 0; j < 3; j++)
				sum += (chk[arr[i][j]] == 1) ? 1 : 0;
			if(arr[i][3] == 0)
			{
				if(sum == 2)
					for(int j = 0; j < 3; j++)
						if(chk[arr[i][j]] == 2) chk[arr[i][j]] = 0;
			}
		}
		
		for(int i = 1; i <= a+b+c; i++)
			System.out.println(chk[i]);
	}
}