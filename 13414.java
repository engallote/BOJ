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
		String[] str = br.readLine().split(" ");
		int K = Integer.parseInt(str[0]);
		int L = Integer.parseInt(str[1]);
		
		LinkedHashSet<String> hs = new LinkedHashSet<>();
		
		for(int i = 0; i < L; i++)
		{
			String s = br.readLine();
			if(hs.contains(s))
				hs.remove(s);
			hs.add(s);
		}
		
		Iterator<String> it = hs.iterator();
		int cnt = 0;
		while(it.hasNext())
		{
			bw.write(it.next() + "\n");
			cnt++;
			if(cnt == K) break;
		}
		bw.flush();
	}
}