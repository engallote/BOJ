import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		boolean[][] arr = new boolean[65][65];
		int max = 0;
		for(int i = 0; i < N; i++)
		{
			char a = sc.next().charAt(0);
			String tmp = sc.next();
			char b = sc.next().charAt(0);
			int idx1 = (a >= 'A' && a <= 'Z') ? a - 'A' : a - 'a' + 26;
			int idx2 = (b >= 'A' && b <= 'Z') ? b - 'A' : b - 'a' + 26;
			
			arr[idx1][idx2] = true;
			if(max < idx1) max = idx1;
			if(max < idx2) max = idx2;
		}
		
		for(int k = 0; k <= max; k++)
			for(int i = 0; i <= max; i++)
				for(int j = 0; j <= max; j++)
					if(arr[i][k] && arr[k][j]) arr[i][j] = true;
		
		Queue<String> ans = new LinkedList<>();
		
		for(int i = 0; i <= max; i++)
			for(int j = 0; j <= max; j++)
				if(arr[i][j] && i != j)
				{
					if(i < 26)//A
					{
						if(j < 26)
							ans.add((char)(i+'A') + " => " + (char)(j+'A'));
						else
							ans.add((char)(i+'A') + " => " + (char)(j+'a'-26));
					}
					else//a
					{
						if(j < 26)
							ans.add((char)(i+'a'-26) + " => " + (char)(j+'A'));
						else
							ans.add((char)(i+'a'-26) + " => " + (char)(j+'a'-26));
					}
				}
		System.out.println(ans.size());
		while(!ans.isEmpty())
			System.out.println(ans.poll());
		
	}
}