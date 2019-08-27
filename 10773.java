import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		Stack<Integer> st = new Stack<>();
		for(int t = 0; t < tc; t++)
		{
			int N = sc.nextInt();
			if(N != 0)
				st.push(N);
			else
				st.pop();
		}
		int sum = 0;
		for(int i : st)
			sum += i;
		System.out.println(sum);
	}
}