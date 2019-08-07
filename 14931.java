import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
	static int N;
	static long[] arr;
	public static void main(String[] args) throws IOException {
//		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		arr = new long[N + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		long res = 0, jump = 1;
		for(int i = 1; i <= N; i++)
		{
			arr[i] = Long.parseLong(st.nextToken());
			res += arr[i];
		}
		
		for(int i = 2; i <= N; i++)
		{
			long sum = 0;
			for(int j = i; j <= N; j += i)
				sum += arr[j];
			if(res < sum)
			{
				res = sum;
				jump = i;
			}
		}
		
		if(res <= 0)
		{
			res = 0;
			jump = 0;
		}
		
//		System.out.println(jump + " " + res);
		bw.write(jump + " " + res);
		bw.flush();
	}
}