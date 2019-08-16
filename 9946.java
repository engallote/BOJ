import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = 1;
		while(true)
		{
			String a = sc.next();
			String b = sc.next();
			
			if(a.equals("END") && b.equals("END")) break;
			char[] c = a.toCharArray();
			int[] arr = new int[26];
			
			for(int i = 0; i < c.length; i++)
				arr[c[i]-'a']++;
			
			char[] c2 = b.toCharArray();
			for(int i = 0; i < c2.length; i++)
				arr[c2[i]-'a']--;
			
			Arrays.sort(arr);
			if(arr[25] != 0 || arr[0] != 0)
				System.out.println("Case " + tc + ": different");
			else
				System.out.println("Case " + tc + ": same");
			tc++;
		}
	}
}