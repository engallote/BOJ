import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] c = sc.next().toCharArray();
		Stack<Character> st = new  Stack<>();
		for(int i = 0; i < c.length; i++)
		{
			if(c[i] == '(') st.push(c[i]);
			else
			{
				if(st.isEmpty() || st.peek() == ')') st.push(c[i]);
				else st.pop();
			}
		}
		
		System.out.println(st.size());
	}
}