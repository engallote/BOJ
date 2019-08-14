import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
	static BufferedWriter bw;
	static int len;
	static StringBuilder sb;
	static boolean[] chk;
	static int[] arr;
	static char[] c;
	public static void main(String[] args) throws IOException {
//		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		for(int i = 0; i < N; i++)
		{
			c = br.readLine().toCharArray();
			Arrays.sort(c);
			sb = new StringBuilder();
			len = c.length;
			arr = new int[130];
			for(char ch : c) arr[ch]++;
			solve(0);
		}
		bw.flush();
	}
	private static void solve(int idx) throws IOException {
		if(idx == len)
		{
			System.out.println(sb.toString());
			return;
		}
		for(int i = 0; i < 130; i++)
			if(arr[i] > 0)
			{
				arr[i]--;
				sb.append((char)i);
				solve(idx + 1);
				sb.deleteCharAt(sb.length() - 1);
				arr[i]++;
			}
	}
}