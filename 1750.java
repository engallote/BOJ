import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] arr = new int[N][26];
		int res = 0;
		
		for(int i = 0; i < N; i++)
		{
			char[] ch = sc.next().toCharArray();
			for(char c : ch) 
			{
				if(c >= 'a' && c <= 'z') arr[i][c-'a']++;
				else arr[i][c-'A']++;
			}
		}
		
		for(int j = 1; j < N; j++)
		{
			int sum = 0, a = 0, b = 0;
			for(int k = 0; k < 26; k++)
			{
				sum += Math.abs(arr[0][k] - arr[j][k]);
				a += arr[0][k];
				b += arr[j][k];
			}
			
			if(sum <= 1 || (Math.abs(b - a) <= 1 && sum == 2)) 
				res++;
		}
		System.out.println(res);
	}
}