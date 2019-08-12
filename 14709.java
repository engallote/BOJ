import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		boolean[][] arr = new boolean[6][6];
		for(int i = 0; i < N; i++)
		{
			int a = sc.nextInt();
			int b = sc.nextInt();
			if(a == b) continue;
			arr[a][b] = arr[b][a] = true;
		}
		boolean flag = true;
		for(int i = 1; i <= 5; i++)
			if(arr[2][i] || arr[5][i])
			{
				flag = false;
				break;
			}
		
		if(!arr[1][3] || !arr[3][4] || !arr[1][4]) flag = false;
			
		if(flag)
			System.out.println("Wa-pa-pa-pa-pa-pa-pow!");
		else
			System.out.println("Woof-meow-tweet-squeek");
	}
}