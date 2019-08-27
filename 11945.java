import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
	static char[][] map = new char[11][11];
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] str = br.readLine().split(" ");
		int N = Integer.parseInt(str[0]);
		int M = Integer.parseInt(str[1]);
		if(N == 0 || M == 0) return;
		for(int i = 0; i < N; i++)
			map[i] = br.readLine().toCharArray();
		
		for(int i = 0; i < N; i++)
		{
			for(int j = M - 1; j >= 0; j--)
				bw.write(map[i][j]);
			bw.write("\n");
		}
		bw.flush();
	} 
}