import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
	static long M = 0, L = 0;
	static char[] ch;
	static String[] ss;
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		ch = s.toCharArray();
		ss = new String[s.length()];
		for(int i = 0; i < s.length(); i++)
			ss[i] = Character.toString(ch[i]);
		
		long ans = sc.nextLong();
		f();
		l();
//		System.out.println(M + " " + L);
		if(ans == M && ans == L)
			System.out.println("U");
		else if(ans == M && ans != L)
			System.out.println("M");
		else if(ans != M && ans == L)
			System.out.println("L");
		else
			System.out.println("I");
	}
	private static void l() {
		long sum = 0;
		int p = 1;//1은 더하기, 2는 곱하기
		for(int i = 0; i < ch.length; i++)
		{
			if(ch[i]-'0' >= 0 && ch[i]-'0' <= 9)
			{
				int num = ch[i]-'0';
				if(p == 1)
					sum += num;
				else if(p == 2)
					sum *= num;
			}
			else
			{
				if(ch[i] == '+')
					p = 1;
				else if(ch[i] == '*')
					p = 2;
			}		
		}	
		L = sum;
	}
	private static void f() {
		for(int i = 0; i < ss.length; i++)
		{
			if(ss[i].equals("*"))//곱해야 하는 숫자 인덱스 넣기
			{
				long num1 = Long.parseLong(ss[i-1]);
				long num2 = Long.parseLong(ss[i+1]);
				long res = num1 * num2;
				ss[i-1] = "f";//계산 완료한 숫자라는 표시
				ss[i+1] = Long.toString(res);
			}
		}
		int sum = 0;
		for(int i = 0; i < ss.length; i++)
		{
//			System.out.print(ss[i] + " ");
			if(ss[i].equals("f")) continue;
			else if(ch[i]-'0' >= 0 && ch[i]-'0' <= 9)
			{
				sum += Long.parseLong(ss[i]);
//				System.out.println(">>> " + sum);
			}
		}
		M = sum;
	}
}