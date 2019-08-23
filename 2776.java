import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int tc = Integer.parseInt(br.readLine());
		
		for(int t = 0; t < tc; t++)
		{
			int N = Integer.parseInt(br.readLine());
			String[] str = br.readLine().split(" ");
			HashSet<Integer> hs = new HashSet<>();
			for(int i = 0; i < N; i++)
				hs.add(Integer.parseInt(str[i]));
			
			int M = Integer.parseInt(br.readLine());
			str = br.readLine().split(" ");
			for(int i = 0; i < M; i++)
			{
				if(hs.contains(Integer.parseInt(str[i])))
					bw.write(1+"\n");
				else
					bw.write(0+"\n");
			}
			bw.flush();
		}
	}
}