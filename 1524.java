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
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		
		int[] s = new int[1000001], b = new int[1000001];
		for(int test_case = 1; test_case <= T; test_case++)
		{
			br.readLine();
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++)
				s[i] = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < M; i++)
				b[i] = Integer.parseInt(st.nextToken());
			
			Arrays.sort(s, 0, N);
			Arrays.sort(b, 0, M);
			
			int i = 0, j = 0;
			
			for(i = 0, j = 0;;)
			{
				if(i == N || j == M)
				{
					if(i == N) bw.write("B\n");
					else bw.write("S\n");;
					break;
				}
//				System.out.println(s[i] + " " + b[j]);
				if(s[i] < b[j]) i++;
				else j++;
			}
		}
		bw.flush();
	}
}