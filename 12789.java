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
		int N = Integer.parseInt(br.readLine());
		Queue<Integer> q = new LinkedList<>();
		Stack<Integer> st = new Stack<>();
		StringTokenizer str = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++)
			q.add(Integer.parseInt(str.nextToken()));
		
		int num = 1;
		while(num <= N)
		{
			if(!q.isEmpty() && q.peek() == num) 
			{
//				System.out.println("q : " + q.peek());
				q.poll();
				num++;
			}
			else if(!st.isEmpty() && st.peek() == num) 
			{
//				System.out.println("st : " + st.peek());
				st.pop();
				num++;
			}
			else if(!q.isEmpty())
				st.add(q.poll());
			else break;
		}
		
		
		
		if(q.isEmpty() && st.isEmpty()) bw.write("Nice");
		else bw.write("Sad");
		bw.flush();
	}
}