import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
//		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true)
		{
			int N = Integer.parseInt(br.readLine());
			if(N == 0) break;
			int col = 0;
			for(int i = 0; i < N; i++)
			{
				boolean flag = false;
				char[] c = br.readLine().toCharArray();
				for(int j = 0; j < c.length; j++)
				{
//					System.out.print(c[j]);
					if(col <= j && c[j] == ' ')
					{
						col = j;
						flag = true;
						break;
					}
				}
//				System.out.println();
				if(!flag) col = Math.max(col, c.length);
			}
			
			System.out.println(col+1);
		}
	}
}