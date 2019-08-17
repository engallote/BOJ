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
			StringTokenizer st;
			int N = Integer.parseInt(br.readLine());
			int[] arr1 = new int[N];
			int res = 0;
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++)
				arr1[i] = Integer.parseInt(st.nextToken());
			
			int N2 = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			int[] arr2 = new int[N2];
			for(int i = 0; i < N2; i++)
				arr2[i] = Integer.parseInt(st.nextToken());
			
			int N3 = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			int[] arr3 = new int[N3];
			for(int i = 0; i < N3; i++)
				arr3[i] = Integer.parseInt(st.nextToken());
			HashSet<Integer> hs = new HashSet<>();
			for(int i = 0; i < N; i++)
				for(int j = 0; j < N2; j++)
					for(int k = 0; k < N3; k++)
					{
						int sum = arr1[i] + arr2[j] + arr3[k];
						int tmp = sum;
						int num = 0;
						while(sum > 0)
						{
							if(sum % 10 == 5 || sum % 10 == 8)
							{
								num = sum % 10;
								sum /= 10;
							}
							else
							{
								num = 100;
								break;
							}
						}
						if(num != 100)
							hs.add(tmp);
					}
			
			res = hs.size();
			bw.write(res+"\n");
		}
		bw.flush();
	}
}