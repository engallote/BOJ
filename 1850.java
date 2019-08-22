import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
//		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] str = br.readLine().split(" ");
		long A = Long.parseLong(str[0]);
		long B = Long.parseLong(str[1]);
		long res = gcd(A, B);
		for(int i = 0; i < res; i++)
			bw.write(1+"");
		bw.flush();
	}
	public static long gcd(long A, long B)
	{
		if(A < B)
		{
			long tmp = A;
			A = B;
			B = tmp;
		}
		if(B == 0)
			return A;
		return gcd(B, A % B);
	}
}