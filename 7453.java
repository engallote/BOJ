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
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][4];
		
		String[] str;
		for(int i = 0; i < N; i++)
		{
			str = br.readLine().split(" ");
			arr[i][0] = Integer.parseInt(str[0]);
			arr[i][1] = Integer.parseInt(str[1]);
			arr[i][2] = Integer.parseInt(str[2]);
			arr[i][3] = Integer.parseInt(str[3]);
		}
		
		long[] ab = new long[N * N], cd = new long[N * N];
		int idx = 0;
		for(int i = 0; i < N; i++)
			for(int j = 0; j < N; j++)
			{
				long sab = arr[i][0] + arr[j][1], scd = arr[i][2] + arr[j][3];
				ab[idx] = sab;
				cd[idx] = scd;
				idx++;
			}
		
		
		Arrays.sort(ab);
		Arrays.sort(cd);
		
		long cnt = 0;
		int l = 0, r = cd.length - 1;
		while(true)
		{
//			System.out.println(ab.get(l) + " " + cd.get(r));
			long sumA = ab[l], sumB = cd[r];
			long sum = sumA + sumB;
			if(sum == 0)
			{
				long c1 = 1, c2 = 1;
				while(l + 1 < ab.length && sumA == ab[l + 1])
				{
					l++;
					c1++;
				}
				while(r - 1 >= 0 && sumB == cd[r - 1])
				{
					r--;
					c2++;
				}
				cnt += c1 * c2;
				l++;
			}
			else if(sum > 0)
				r--;
			else if(sum < 0)
				l++;
			if(l >= ab.length || r < 0) break;
		}
		
		bw.write(cnt+"");
		bw.flush();
	}
}