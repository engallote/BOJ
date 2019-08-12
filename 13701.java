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
		HashSet<Long> hs = new HashSet<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		while(st.hasMoreTokens())
		{
			long num = Long.parseLong(st.nextToken());
			if(!hs.contains(num))
			{
				hs.add(num);
				bw.write(num + " ");
			}
		}
		bw.flush();
	}
}