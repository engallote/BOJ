import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
//		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			if(N == 0) break;
			Stack<String> stack = new Stack<>();
			for(int i = 0; i < N; i++)
			{
				String num = st.nextToken();
				if(stack.isEmpty() || !stack.peek().equals(num))
					stack.push(num);
			}
			
			StringBuilder ans = new StringBuilder();
			for(String s : stack)
				ans.append(s + " ");
			ans.append("$");
			System.out.println(ans);
		}
	}
}