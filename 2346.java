import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N+1];
		boolean[] visit = new boolean[N+1];
		Vector<Integer> v = new Vector<>();
		for(int i = 1; i <= N; i++)
			arr[i] = sc.nextInt();
		
		int idx = 1, jump = arr[1], cnt = 0, sw = 1;
		visit[1] = true;
		v.add(1);
		if(jump < 0)
			sw = -1;
		while(true)
		{
			int count = 0, num = 0;
			while(cnt != jump)
			{
				idx += sw;
				if(idx > N)
					idx = 1;
				if(idx == 0)
					idx = N;
				while(visit[idx])
				{
					idx += sw;
					if(idx > N)
						idx = 1;
					else if(idx == 0)
						idx = N;
				}
				cnt += sw;
			}
			cnt = 0;
			v.add(idx);
			visit[idx] = true;
			jump = arr[idx];
			if(jump < 0 && sw == 1)
				sw = -1;
			else if(jump > 0 && sw == -1)
				sw = 1;
			for(int i = 1; i <= N; i++)
			{
				if(visit[i]) count++;
				else num = i;
			}
			if(count == N - 1)
			{
				v.add(num);
				break;
			}
		}
		for(int i : v)
			System.out.print(i + " ");
	} 
}