import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		
		for(int t = 0; t < tc; t++)
		{
			char[] arr = sc.next().toCharArray();
			int len = arr.length;
			int m = (int)Math.sqrt(len);
			char[][] res = new char[m][m];
			int idxR = m - 1, idxC = 0;
			
			for(int i = 0; i < len; i++)
			{
//				System.out.println(idxR + " " + idxC);
				res[idxR][idxC] = arr[i];
				idxR--;
				if(idxR == -1)
				{
					idxC++;
					idxR = m-1;
				}
			}
			
			for(int i = 0; i < m; i++)
				for(int j = 0; j < m; j++)
					System.out.print(res[i][j]);
			System.out.println();
		}
	}
}