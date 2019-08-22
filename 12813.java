import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] A = sc.next().toCharArray();
		char[] B = sc.next().toCharArray();
		
//		if(A.length < B.length)
		
		for(int i = 0; i < A.length; i++)
		{
			if(A[i] == '1' && B[i] == '1')
				System.out.print(1);
			else System.out.print(0);
		}
		System.out.println();
		
		for(int i = 0; i < A.length; i++)
		{
			if(A[i] == '1' || B[i] == '1')
				System.out.print(1);
			else System.out.print(0);
		}
		System.out.println();
		
		for(int i = 0; i < A.length; i++)
		{
			if(A[i] == '1' && B[i] == '1')
				System.out.print(0);
			else if((A[i] == '1' && B[i] == '0') || (A[i] == '0' && B[i] == '1'))
				System.out.print(1);
			else System.out.print(0);
		}
		System.out.println();
		
		for(int i = 0; i < A.length; i++)
		{
			if(A[i] == '1')
				System.out.print(0);
			else
				System.out.print(1);
		}
		System.out.println();
		for(int i = 0; i < B.length; i++)
		{
			if(B[i] == '1')
				System.out.print(0);
			else
				System.out.print(1);
		}
	}
}