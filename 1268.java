import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] arr = new int[N][5];
		
		for(int i = 0; i < N; i++)
		{
			for(int j = 0; j < 5; j++)
				arr[i][j] = sc.nextInt();
		}
		
		int max = 0, idx = 0, cnt = 0;
		boolean[] chk = new boolean[N];
		for(int i = 0; i < N; i++)
		{
			cnt = 0;
			Arrays.fill(chk, false);
			for(int j = 0; j < 5; j++)
			{
				for(int k = 0; k < N; k++)
					if(i != k && !chk[k] && arr[k][j] == arr[i][j])
					{
						chk[k] = true;
						cnt++;
					}
			}
			if(max < cnt)
			{
				max = cnt;
				idx = i + 1;
			}
		}
		if(idx == 0) idx = 1;
		System.out.println(idx);
	}
}