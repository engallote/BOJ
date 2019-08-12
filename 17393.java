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
		long[] a = new long[N];
		long[] b = new long[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) a[i] = Long.parseLong(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) b[i] = Long.parseLong(st.nextToken());
		
		for(int i = 0; i < N - 1; i++)
		{
			int l = i + 1, r = N - 1, mid = 0, sum = 0;
			while(l <= r)
			{
				mid = (l + r) / 2;
				if(mid >= N) r = mid - 1;
				else if(mid <= i) l = mid + 1;
				else if(b[mid] <= a[i])
				{
					sum = Math.max(sum, mid - i);
					l = mid + 1;
				}
				else r = mid - 1;
			}
				
			bw.write(sum + " ");
		}
		bw.write("0");
		bw.flush();
	}
}