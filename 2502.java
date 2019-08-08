import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int sum = 0, pre1 = 0, pre2 = 0;
		for(int i = 1; i <= K; i++)
			for(int j = i + 1; j <= K; j++)
			{
				pre1 = i;
				pre2 = j;
				sum = i + j;
//				System.out.println("start : " + i + " " + j);
				for(int k = 3; k <= N; k++)
				{
					int num = pre1 + pre2;
					sum = num;
					if(sum > K) break;
					pre1 = pre2;
					pre2 = num;
//					System.out.println(pre1 + " " + pre2);
				}
//				System.out.println(">>>>> " + sum);
				if(sum == K)
				{
					System.out.println(i + "\n" + j);
					return;
				}
			}
	}
}