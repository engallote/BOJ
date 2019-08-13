import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] c = sc.next().toCharArray();
		Stack<Character> st = new Stack<>();
		int res = 0;
		for(int i = 0; i < c.length; i++)
		{
			if(c[i] >= '0' && c[i] <= '9')
			{
				int sum = 0;
				for(int j = 0; j < st.size(); j++)
				{
					if(st.get(j) == '(') sum++;
					else if(st.get(j) == '{') sum += 2;
					else sum += 3;
				}
				res = Math.max(res, sum);
			}
			else if(c[i] == ')' || c[i] == '}' || c[i] == ']') st.pop();
			else st.push(c[i]);
		}
		
		System.out.println(res);
	}
}