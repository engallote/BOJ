import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.nextLine();
		int[] arr = new int['Z'+1];
		int num = 1;
		for(char c = 'A'; c <= 'Z'; c++)
			arr[c] = num++;
		
		for(int i = 0; i < N; i++)
		{
			char[] c = sc.nextLine().toCharArray();
			int sum = 0;
			for(char ch : c)
				if(ch != ' ')
					sum += arr[ch];
			if(sum == 100) System.out.println("PERFECT LIFE");
			else System.out.println(sum);
		}
	}
}