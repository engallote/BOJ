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
		HashMap<String, Integer> hs = new HashMap<>();
		
		for(int i = 0; i < N; i++)
		{
			String num = st.nextToken();
			if(hs.containsKey(num))
			{
				int val = hs.get(num);
				hs.remove(num);
				hs.put(num, val + 1);
			}
			else
				hs.put(num, 1);
		}
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < M; i++)
		{
			String num = st.nextToken();
			
			if(hs.containsKey(num))
				bw.write(hs.get(num) + " ");
			else
				bw.write("0 ");
		}
		bw.flush();
	}
}