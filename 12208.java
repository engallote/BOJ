import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = sc.nextInt();
			String dir = sc.next();
			
			int[][] arr = new int[N][N];
			
			for(int i = 0; i < N; i++)
				for(int j = 0; j < N; j++)
					arr[i][j] = sc.nextInt();
			
			if(dir.equals("right"))
			{
				for(int i = 0; i < N; i++)
				{
					for(int j = N - 1; j >= 0; j--)
					{
						int ny = j - 1;
						
						while(ny >= 0)
						{
							if(arr[i][ny] != 0)
							{
								if(arr[i][j] == 0)
								{
									arr[i][j] = arr[i][ny];
									arr[i][ny] = 0;
									ny--;
									continue;
								}
								else if(arr[i][j] == arr[i][ny])
								{
									arr[i][j] += arr[i][ny];
									arr[i][ny] = 0;
								}
								break;
							}
							ny--;
						}
					}
				}
			}
			else if(dir.equals("left"))
			{
				for(int i = 0; i < N; i++)
				{
					for(int j = 0; j < N; j++)
					{
						int ny = j + 1;
						
						while(ny < N)
						{
							if(arr[i][ny] != 0)
							{
								if(arr[i][j] == 0)
								{
									arr[i][j] = arr[i][ny];
									arr[i][ny] = 0;
									ny++;
									continue;
								}
								else if(arr[i][j] == arr[i][ny])
								{
									arr[i][j] += arr[i][ny];
									arr[i][ny] = 0;
								}
								break;
							}
							ny++;
						}
					}
				}
			}
			else if(dir.equals("up"))
			{
				for(int j = 0; j < N; j++)
				{
					for(int i = 0; i < N; i++)
					{
						int nx = i + 1;
						
						while(nx < N)
						{
							if(arr[nx][j] != 0)
							{
								if(arr[i][j] == 0)
								{
									arr[i][j] = arr[nx][j];
									arr[nx][j] = 0;
									nx++;
									continue;
								}
								else if(arr[i][j] == arr[nx][j])
								{
									arr[i][j] += arr[nx][j];
									arr[nx][j] = 0;
								}
								break;
							}
							nx++;
						}
					}
				}
			}
			else
			{
				for(int j = 0; j < N; j++)
				{
					for(int i = N - 1; i >= 0; i--)
					{
						int nx = i - 1;
						
						while(nx >= 0)
						{
							if(arr[nx][j] != 0)
							{
								if(arr[i][j] == 0)
								{
									arr[i][j] = arr[nx][j];
									arr[nx][j] = 0;
									nx--;
									continue;
								}
								else if(arr[i][j] == arr[nx][j])
								{
									arr[i][j] += arr[nx][j];
									arr[nx][j] = 0;
								}
								break;
							}
							nx--;
						}
					}
				}
			}
			System.out.println("Case #" + test_case + ":");
			for(int i = 0; i < N; i++)
			{
				for(int j = 0; j < N; j++)
					System.out.print(arr[i][j] + " ");
				System.out.println();
			}
		}
	}
}