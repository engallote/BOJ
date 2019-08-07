import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
//		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			char[] a = br.readLine().toCharArray();
			char[] b = br.readLine().toCharArray();
			int[] arr = new int[33];
			
			for(int i = 0; i < a.length; i++)
				arr[a[i]-'a']++;
			for(int i = 0; i < b.length; i++)
				arr[b[i]-'a']--;
			
			int res = 0;
			for(int i = 0; i < 32; i++)
				if(arr[i] != 0) res += Math.abs(arr[i]);
			System.out.println("Case #" + test_case + ": " + res);
		}
	}
}