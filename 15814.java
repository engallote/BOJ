import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
//		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		char[] c = br.readLine().toCharArray();
		int t = Integer.parseInt(br.readLine());
		String[] str;
		for(int i = 0; i < t; i++)
		{
			str = br.readLine().split(" ");
			int a = Integer.parseInt(str[0]);
			int b = Integer.parseInt(str[1]);
			
			char tmp = c[a];
			c[a] = c[b];
			c[b] = tmp;
		}
		
		for(char s : c)
			bw.write(s);
		bw.flush();
	}
}