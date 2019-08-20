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
		char[] c = br.readLine().toCharArray();
		int len = c.length;
		HashSet<String> hs = new HashSet<>();
		for(int i = 0; i < len; i++)
		{
			StringBuilder tmp = new StringBuilder();
			tmp.append(c[i]);
			hs.add(tmp.toString());
			for(int j = i + 1; j < len; j++)
			{
				tmp.append(c[j]);
				hs.add(tmp.toString());
			}
		}
		bw.write(hs.size()+"");
		bw.flush();
	}
}