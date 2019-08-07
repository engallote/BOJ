import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
	static int N, d, k, c;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		arr = new int[N];
		for(int i = 0; i < N; i++) 
			arr[i] = Integer.parseInt(br.readLine());
		
		int res = 0, idx = 0, cnt = 0, eat = 0;
		HashSet<Integer> hs = new HashSet<>(); 
		for(int i = 0; i < N; i++)
		{
			hs.clear();
			cnt = 0;
			idx = i;
			eat = 0;
			while(cnt < k)
			{
				if(!hs.contains(arr[idx]))
				{
					hs.add(arr[idx]);
					eat++;
				}
				cnt++;
				idx++;
				if(idx == N) idx = 0;
			}
			if(!hs.contains(c)) eat++;
			res = Math.max(res, eat);
		}
		bw.write(res+"");
		bw.flush();
	}
}