import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
//        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        char[][] arr = new char[R][S];
        boolean[] m = new boolean[S], g = new boolean[S];
        int[] h = new int[S], h2 = new int[S];
        ArrayList<Pair> aly = new ArrayList<>();
        Arrays.fill(h, Integer.MAX_VALUE);
        for(int i = 0; i < R; i++)
        {
        	arr[i] = br.readLine().trim().toCharArray();
        	for(int j = 0; j < S; j++)
        	{
        		if(arr[i][j] == 'X')
        		{
        			arr[i][j] = '.';
        			m[j] = true;
        			h2[j] = Math.max(h2[j], i);
        			aly.add(new Pair(i, j));
        		}
        		else if(arr[i][j] == '#')
        		{
        			g[j] = true;
        			h[j] = Math.min(h[j], i-1);
        		}
        	}
        }
        
        int dist = R;
        for(int i = 0; i < S; i++)
        	if(m[i] && g[i])
        		dist = Math.min(dist, Math.abs(h[i] - h2[i]));
        
        for(Pair p : aly)
        	arr[p.r + dist][p.c] = 'X';
        
        for(int i = 0; i < R; i++)
        {
        	for(int j = 0; j < S; j++)
        		bw.write(arr[i][j]+"");
        	if(i < R - 1)
        		bw.write("\n");
        }
        bw.flush();
	}
}
class Pair{
	int r, c;
	Pair(int r, int c)
	{
		this.r = r;
		this.c = c;
	}
}