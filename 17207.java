import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] arr = new int[5][5], arr2 = new int[5][5];
		int[] ans = new int[5];
		
		for(int i = 0; i < 5; i++)
			for(int j = 0; j < 5; j++)
				arr[i][j] = sc.nextInt();
		
		for(int i = 0; i < 5; i++)
			for(int j = 0; j < 5; j++)
				arr2[i][j] = sc.nextInt();
		int idx = 0, max = Integer.MAX_VALUE;
		for(int x = 0; x < 5; x++)
		{
			for(int y = 0; y < 5; y++)
				for(int i = 0; i < 5; i++)
					ans[x] += (arr[x][i] * arr2[i][y]);
			if(max >= ans[x])
			{
				max = ans[x];
				idx = x;
			}
		}
		
		switch(idx){
		case 0: System.out.println("Inseo"); break;
		case 1: System.out.println("Junsuk"); break;
		case 2: System.out.println("Jungwoo"); break;
		case 3: System.out.println("Jinwoo"); break;
		case 4: System.out.println("Youngki"); break;
		}
	}
}