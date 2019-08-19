import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] c = sc.next().toCharArray();
		Stack<Integer> st = new Stack<>();
		
		for(char ch : c)
		{
			if(ch >= '0' && ch <= '9') st.push(ch-'0');
			else
			{
				int num1 = st.pop(), num2 = st.pop();
				
				if(ch == '+') num2 += num1;
				else if(ch == '*') num2 *= num1;
				else if(ch == '/') num2 /= num1;
				else num2 -= num1;
				
				st.push(num2);
			}
		}
		System.out.println(st.peek());
	}
}