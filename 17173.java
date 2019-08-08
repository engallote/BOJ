import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int res = 0;
		HashSet<Integer> hs = new HashSet<>();
		for(int i = 0; i < M; i++)
		{
			int num = sc.nextInt();
			
			for(int j = 1;; j++)
			{
				if(num * j > N) break;
				if(!hs.contains(num * j))
				{
					hs.add(num * j);
					res += (num * j);
				}
			}
		}
			
		System.out.println(res);
	}
}