import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		HashSet<Integer> hs = new HashSet<>();
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = sc.nextInt();
			int[] arr = new int[N];
			for(int i = 0; i < N; i++) arr[i] = sc.nextInt();
			
			boolean flag = true;
			for(int i = 1;; i++)
			{
				hs.clear();
				flag = true;
				for(int j = 0; j < N; j++)
				{
					if(hs.contains(arr[j]%i))
					{
						flag = false;
						break;
					}
					hs.add(arr[j]%i);
				}
				if(flag)
				{
					System.out.println(i);
					break;
				}
			}
		}
	}
}