import java.util.*;

public class Main {
	static int N, L, I;
	static HashSet<String> hs = new HashSet<>();
	static Vector<String> v = new Vector<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		
		for(int t = 0; t < tc; t++)
		{
			N = sc.nextInt();
			int[] arr = new int[N];
			Vector<Integer> tmp = new Vector<>();
			for(int i = 0; i < N; i++)
				arr[i] = sc.nextInt();
			
			System.out.println(N / 2 + 1);
			tmp.clear();
			tmp.addElement(arr[0]);
			int cnt = 1;
			System.out.print(arr[0] + " ");
			for(int i = 1; i < N; i++)
			{
				tmp.add(arr[i]);
				if(i % 2 == 0)
				{
					if(cnt == 10)
					{
						System.out.println();
						cnt = 0;
					}
					cnt++;
					tmp.sort(null);
					System.out.print(tmp.get(tmp.size() / 2) + " ");
				}
			}
			System.out.println();
		}
	}
}