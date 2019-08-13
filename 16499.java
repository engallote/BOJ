import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		HashSet<String> hs = new HashSet<>();
		int[] arr = new int[26];
		for(int i = 0; i < N; i++)
		{
			char[] c = sc.next().toCharArray();
			Arrays.fill(arr, 0);
			
			for(int j = 0; j < c.length; j++)
				arr[c[j]-'a']++;
			
			StringBuilder sb = new StringBuilder();
			for(int j = 0; j < 26; j++)
				if(arr[j] > 0) sb.append(j+":"+arr[j]+",");
			hs.add(sb.toString());
		}
		
		System.out.println(hs.size());
	}
}