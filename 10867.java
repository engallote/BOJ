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
		String[] str = br.readLine().split(" ");
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int i = 0; i < N; i++)
		{
			int num = Integer.parseInt(str[i]);
			if(pq.isEmpty())
				pq.add(num);
			else if(!pq.isEmpty() && !pq.contains(num))
				pq.add(num);
		}
		
		while(!pq.isEmpty())
			bw.write(pq.poll() + " ");
		bw.flush();
	}
}