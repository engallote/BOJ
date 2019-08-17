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
		StringTokenizer st;
		while(true)
		{
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			if(N == 0 && M == 0) break;
			HashSet<Long> hs = new HashSet<>();
			for(int i = 0; i < N; i++)
				hs.add(Long.parseLong(br.readLine()));
			long res = 0;
			for(int i = 0; i < M; i++)
			{
				long n = Long.parseLong(br.readLine());
				if(hs.contains(n)) res++;
			}
			bw.write(res+"\n");
		}
		bw.flush();
	}
}