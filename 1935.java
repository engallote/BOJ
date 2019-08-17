import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		char[] c = sc.next().toCharArray();
		double[] arr = new double[N];
		for(int i = 0; i < N; i++)
			arr[i] = sc.nextDouble();
		
		Stack<Double> st = new Stack<>();
		for(int i = 0; i < c.length; i++)
		{
			if(c[i] >= 'A' && c[i] <= 'Z')
				st.push(arr[c[i] - 'A']);
			else
			{
				double num2 = st.pop(), num1 = st.pop();
//				System.out.println(num1 + " " + num2);
				switch(c[i]){
				case '*': num1 *= num2; break;
				case '+': num1 += num2; break;
				case '/': num1 /= num2; break;
				case '-': num1 -= num2; break;
				}
//				System.out.println(">>" + num1);
				st.push(num1);
			}
		}
		System.out.printf("%.2f\n", st.pop());
	}
}