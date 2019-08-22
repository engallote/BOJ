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
		int tc = Integer.parseInt(br.readLine());
		
		for(int t = 0; t < tc; t++)
		{
			String[] str = br.readLine().split(" ");
			int B = Integer.parseInt(str[0]);
			long sum = 0;
			for(int i = 0; i < str[1].length(); i++)
				sum += str[1].charAt(i) - '0';
			
			B--;
			bw.write((sum % B)+"\n");
		}
		bw.flush();
	}
}