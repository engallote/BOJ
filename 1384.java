import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int g = 1;
		
		while(true)
		{
			int N = sc.nextInt();
			if(N == 0) break;
			String[] name = new String[N];
			int[][] arr = new int[N][N-1];
			
			for(int i = 0; i < N; i++)
			{
				name[i] = sc.next();
				
				for(int j = 0; j < N - 1; j++)
				{
					char c = sc.next().charAt(0);
					if(c == 'P')
						arr[i][j] = 1;
				}
			}
			
			System.out.println("Group " + g);
			boolean flag = true;
			for(int i = 0; i < N; i++)
			{
				for(int j = 0; j < N-1; j++)
				{
					if(arr[i][j] == 0)
					{
						if(i - j - 1 < 0)
							System.out.println(name[N+(i-j-1)] + " was nasty about " + name[i]);
						else
							System.out.println(name[i-j-1] + " was nasty about " + name[i]);
						flag = false;
					}
				}
			}
			if(flag)
				System.out.println("Nobody was nasty");
			System.out.println();
			g++;
		}
	}
}