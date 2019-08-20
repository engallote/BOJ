import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		char[] c = str.toCharArray();
		int[] arr = new int[26];
		int res = 0;
		
		for(int i = 0; i < 26; i++)
		{
			Arrays.fill(arr, 0);
			int idx = str.indexOf((char)(i+'A'));
			char ch = (char)(i + 'A');
			
			for(int j = idx + 1; j < 52; j++)
			{
				if(c[j] == ch) break;
				arr[c[j]-'A']++;
				if(arr[c[j]-'A'] == 1) res++;
				else res--;
			}
		}
		
		System.out.println(res/2);
	}
}