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
		int T = Integer.parseInt(br.readLine());
		ArrayList<Integer> arr = new ArrayList<>();
		for(int test_case = 1; test_case <= T; test_case++)
		{
			arr.clear();
			StringTokenizer st = new StringTokenizer(br.readLine());
			while(st.hasMoreTokens())
				arr.add(Integer.parseInt(st.nextToken()));
			int max = 0;
			for(int i = 0; i < arr.size(); i++)
				for(int j = i + 1; j < arr.size(); j++)
					max = Math.max(gcd(arr.get(i), arr.get(j)), max);
			bw.write(max+"\n");
		}
		bw.flush();
	}

	private static int gcd(int a, int b) {
		if(b == 0) return a;
		if(a < b)
		{
			int tmp = a;
			a = b;
			b = tmp;
		}
		return gcd(b, a % b);
	}
}