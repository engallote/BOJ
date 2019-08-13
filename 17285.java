import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] c = sc.next().toCharArray();
		int[] arr = {(int)'C', (int)'H', (int)'I', (int)'C', (int)'K', (int)'E', (int)'N', (int)'S'};
		int key = 0, idx = 0;
		
		while(true)
		{
			idx = 0;
			for(int i = 0; i < 8; i++)
			{
				int tmp = (int)c[i] ^ key;
				if(arr[idx] != tmp) break;
				idx++;
			}
			if(idx == 8) break;
			key++;
		}
		
		for(int i = 0; i < c.length; i++)
		{
			int tmp = (int)c[i] ^ key;
			System.out.print((char)tmp);
		}
	}
}