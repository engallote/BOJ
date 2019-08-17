import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		// Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		HashMap<String, Integer> hs = new HashMap<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			String num = st.nextToken();
			if(hs.containsKey(num)) 
			{
				int value = hs.get(num) + 1;
				hs.remove(num);
				hs.put(num, value);
			} 
			else
				hs.put(num, 1);
		}
		String v = br.readLine().trim();
		bw.write((hs.containsKey(v) ? hs.get(v) : 0) + "");
		bw.flush();
	}
}