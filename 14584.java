import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] c = sc.next().toCharArray();
		int len = c.length;
		int N = sc.nextInt();
		
		boolean flag = false;
		int[] arr = new int[26];
		for(int i = 0; i < N; i++)
		{
			char[] tmp = sc.next().toCharArray();
			if(flag) continue;
			for(int j = 0; j <= len - tmp.length; j++)
			{
				Arrays.fill(arr, -1);
				arr[c[j]-'a'] = tmp[0] - 'a';
				
				int idx = c[j] - 'a';
				for(int k = idx + 1; k < 26; k++)
					arr[k] = (arr[k-1] + 1) % 26;
				
				for(int k = idx - 1; k >= 0; k--)
					arr[k] = ((arr[k+1] - 1) >= 0 ? arr[k+1] - 1 : 25);
					
				flag = true;
				int k, id;
				for(k = j, id = 0; k < len && id < tmp.length; k++, id++)
				{
//					System.out.println(arr[c[k]-'a'] + " " + (tmp[id]-'a'));
					if(arr[c[k]-'a'] != tmp[id] -'a')
					{
						flag = false;
						break;
					}
				}
//				System.out.println(flag);
				if(flag && id == tmp.length) flag = true;
				else flag = false;
				if(flag) break;
			}
		}
		
		for(char ch : c)
			System.out.print((char)(arr[ch-'a'] + 'a'));
		System.out.println();
	}
}