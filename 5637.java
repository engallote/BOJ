import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
	static PriorityQueue<Integer> pq = new PriorityQueue<>();
	public static void main(String[] args) throws IOException {
//		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int len = 0;
		String res = "";
		boolean flag = true;
		while(flag)
		{
			String[] str = br.readLine().split(" ");
			for(int i = 0; i < str.length; i++)
			{
				if(str[i].equals("E-N-D"))
				{
					flag = false;
					break;
				}
				char[] c = str[i].toCharArray();
				StringBuilder tmp = new StringBuilder();
				for(int j = 0; j < c.length; j++)
				{
					if((c[j] >= 'a' && c[j] <= 'z') || (c[j] >= 'A' && c[j] <= 'Z') || c[j] == '-')
						tmp.append(c[j]);
					else
					{
						if(tmp.toString().length() > len && tmp.toString().length() <= 100)
						{
							len = tmp.toString().length();
							res = tmp.toString();
						}
						tmp = new StringBuilder();
					}
				}
				if(tmp.toString().length() > len && tmp.toString().length() <= 100)
				{
					len = tmp.toString().length();
					res = tmp.toString();
				}
			}
		}
		bw.write(res.toLowerCase());
		bw.flush();
	}
}