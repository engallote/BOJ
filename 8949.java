import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] a = sc.next().toCharArray();
		char[] b = sc.next().toCharArray();
		
		int idx1 = a.length - 1, idx2 = b.length - 1;
		Stack<Integer> st = new Stack<>();
		while(idx1 >= 0 && idx2 >= 0)
		{
			int aa = a[idx1] - '0';
			int bb = b[idx2] - '0';
			int res = aa + bb;
			st.push(res);
			idx1--;
			idx2--;
		}
		
		while(idx1 >= 0)
			st.push((a[idx1--] - '0'));
		while(idx2 >= 0)
			st.push((b[idx2--] - '0'));
		
		while(!st.isEmpty())
			System.out.print(st.pop());
	}
}