import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int idx = 1, cnt = 0;
		
		for(int i = 0; cnt < 5; i++)
		{
			char[] c = Integer.toBinaryString(i).toCharArray();
			for(char ch : c)
			{
				if(idx == K)
				{
					System.out.print(ch + " ");
					cnt++;
				}
				if(cnt == 5) break;
				idx++;
				if(idx > N) idx = 1;
			}
		}
	}
}