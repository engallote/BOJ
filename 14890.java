import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int L = sc.nextInt();
		int[][] arr = new int[N][N];
		int[][] ver = new int[N][N], hor = new int[N][N];
		for(int i = 0; i < N; i++)
		{
			for(int j = 0; j < N; j++)
			{
				arr[i][j] = sc.nextInt();
				if(j > 0) ver[i][j] = arr[i][j] - arr[i][j-1];
				if(i > 0) hor[i][j] = arr[i][j] - arr[i-1][j];
			}
		}
		
		int res = 0;
		//°¡·Î °Ë»ç
		boolean flag = false;
		boolean[] chk = new boolean[N];
		for(int i = 0; i < N; i++)
		{
			flag = true;
			Arrays.fill(chk, false);
			for(int j = 0; j < N; j++)
			{
				if(chk[j]) continue;
				if(Math.abs(ver[i][j]) >= 2) 
				{
					flag = false;
					break;
				}
				else if(ver[i][j] == -1)//³ô->³·
				{
					int cnt = 0;
					ver[i][j] = 0;
					for(int k = j; k < N; k++)
					{
						if(chk[k]) break;
						else if(ver[i][k] == 0) cnt++;
						else break;
					}
					if(cnt >= L)
					{
						for(int k = j; k < j + L; k++)
							chk[k] = true;
					}
					else
					{
						flag = false;
						break;
					}
				}
				else if(ver[i][j] == 1)//³·->³ô
				{
					int cnt = 0;
					ver[i][j-1] = 0;
					for(int k = j-1; k >= 0; k--)
					{
						if(chk[k]) break;
						else if(ver[i][k] == 0) cnt++;
						else break;
					}
					if(cnt >= L)
					{
						for(int k = j-1; k >= j - L; k--)
							chk[k] = true;
					}
					else 
					{
						flag = false;
						break;
					}
				}
			}
			if(flag) res++;
		}
		//¼¼·Î °Ë»ç
		for(int j = 0; j < N; j++)
		{
			flag = true;
			Arrays.fill(chk, false);
			for(int i = 0; i < N; i++)
			{
				if(chk[i]) continue;
				if(Math.abs(hor[i][j]) >= 2) 
				{
					flag = false;
					break;
				}
				else if(hor[i][j] == -1)//³ô->³·
				{
					int cnt = 0;
					hor[i][j] = 0;
					for(int k = i; k < N; k++)
					{
						if(chk[k]) break;
						else if(hor[k][j] == 0) cnt++;
						else break;
					}
					if(cnt >= L)
					{
						for(int k = i; k < i + L; k++)
							chk[k] = true;
					}
					else
					{
						flag = false;
						break;
					}
				}
				else if(hor[i][j] == 1)//³·->³ô
				{
					int cnt = 0;
					hor[i-1][j] = 0;
					for(int k = i-1; k >= 0; k--)
					{
						if(chk[k]) break;
						else if(hor[k][j] == 0) cnt++;
						else break;
					}
					if(cnt >= L)
					{
						for(int k = i-1; k >= i - L; k--)
							chk[k] = true;
					}
					else 
					{
						flag = false;
						break;
					}
				}
			}
			if(flag) res++;
		}
		System.out.println(res);
	}
}