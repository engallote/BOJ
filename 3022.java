import java.util.*;

public class Main {
	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		HashMap<String, Integer> hs = new HashMap<>();
		int[] arr = new int[N];
		int idx = 0, max = 0,res = 0;
		for(int i = 0; i < N; i++)
		{
			String name = sc.next();
			if(hs.containsKey(name))
			{
				max = 0;
				for(int j = 0; j < idx; j++)
					if(hs.get(name) != j) max += arr[j];
				if(arr[hs.get(name)] > max) res++;
//				System.out.println(arr[hs.get(name)] + " " + max);
				arr[hs.get(name)]++;
			}
			else
			{
				hs.put(name, idx);
				arr[idx]++;
				idx++;
			}
		}
		
		System.out.println(res);
	}
}