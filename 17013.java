import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] order = sc.next().toCharArray();
		int[][] arr = new int[2][2];
		arr[0][0] = 1;
		arr[0][1] = 2;
		arr[1][0] = 3;
		arr[1][1] = 4;
		
		for(char c : order)
		{
			if(c == 'H')
			{
				int[] tmp = arr[1];
				arr[1] = arr[0];
				arr[0] = tmp;
			}
			else
			{
				int tmp = arr[0][0];
				arr[0][0] = arr[0][1];
				arr[0][1] = tmp;
				tmp = arr[1][0];
				arr[1][0] = arr[1][1];
				arr[1][1] = tmp;
			}
		}
		
		for(int i = 0; i < 2; i++)
		{
			for(int j = 0; j < 2; j++)
				System.out.print(arr[i][j]+" ");
			System.out.println();
		}
	}
}