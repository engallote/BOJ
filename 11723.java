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
		int M = Integer.parseInt(br.readLine());
		HashSet<Integer> hs = new HashSet<>();
		String[] str;
		for(int i = 0; i < M; i++)
		{
			str = br.readLine().split(" ");
			if(str[0].equals("add"))
				hs.add(Integer.parseInt(str[1]));
			
			else if(str[0].equals("remove"))
			{
				if(hs.contains(Integer.parseInt(str[1])))
					hs.remove(Integer.parseInt(str[1]));
			}
			else if(str[0].equals("toggle"))
			{
				if(hs.contains(Integer.parseInt(str[1])))
					hs.remove(Integer.parseInt(str[1]));
				else
					hs.add(Integer.parseInt(str[1]));
			}
			else if(str[0].equals("check"))
			{
				if(hs.contains(Integer.parseInt(str[1])))
					bw.write("1\n");
				else
					bw.write("0\n");
			}
			else if(str[0].equals("all"))
			{
				for(int j = 1; j <= 20; j++)
					hs.add(j);
			}
			else
				hs.clear();
		}
		bw.flush();
	}
}