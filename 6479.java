import java.math.BigInteger;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true)
		{
			int N = sc.nextInt();
			if(N == 0) break;
			BigInteger bg = new BigInteger("1");
			for(int i = N; i >= 2; i--)
				bg = bg.multiply(new BigInteger(Integer.toString(i)));
			
			char[] c = bg.toString().toCharArray();
			int[] arr = new int[10];
			for(int i = 0; i < c.length; i++)
				arr[c[i]-'0']++;
			System.out.println(N+"! --");
			System.out.print((arr[0] >= 10 ? (arr[0] >= 100 ? "   (0)  " : "   (0)   ") : "   (0)    ") + arr[0]);
			System.out.print((arr[1] >= 10 ? (arr[1] >= 100 ? "    (1)  " : "    (1)   ") : "    (1)    ") + arr[1]);
			System.out.print((arr[2] >= 10 ? (arr[2] >= 100 ? "    (2)  " : "    (2)   ") : "    (2)    ") + arr[2]);
			System.out.print((arr[3] >= 10 ? (arr[3] >= 100 ? "    (3)  " : "    (3)   ") : "    (3)    ") + arr[3]);
			System.out.print((arr[4] >= 10 ? (arr[4] >= 100 ? "    (4)  " : "    (4)   ") : "    (4)    ") + arr[4]);
			System.out.println();
			System.out.print((arr[5] >= 10 ? (arr[5] >= 100 ? "   (5)  " : "   (5)   ") : "   (5)    ") + arr[5]);
			System.out.print((arr[6] >= 10 ? (arr[6] >= 100 ? "    (6)  " : "    (6)   ") : "    (6)    ") + arr[6]);
			System.out.print((arr[7] >= 10 ? (arr[7] >= 100 ? "    (7)  " : "    (7)   ") : "    (7)    ") + arr[7]);
			System.out.print((arr[8] >= 10 ? (arr[8] >= 100 ? "    (8)  " : "    (8)   ") : "    (8)    ") + arr[8]);
			System.out.print((arr[9] >= 10 ? (arr[9] >= 100 ? "    (9)  " : "    (9)   ") : "    (9)    ") + arr[9]);
			System.out.println();
		}
	}
}