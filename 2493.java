import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
//		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N+1];
		for(int i = 1; i <= N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		int[] ans = new int[N+1];
		for(int i = N; i > 1 ; i--)
		{
			for(int j = i - 1; j >= 1; j--)
				if(arr[i] < arr[j])
				{
					ans[i] = j;
					break;
				}
		}
		
		for(int i = 1; i <= N; i++)
			bw.write(ans[i] + " ");
		bw.flush();
	}
}