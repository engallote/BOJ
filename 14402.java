import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(), idx = 0, res = 0;
		int[] arr = new int[100001];
		HashMap<String, Integer> hs = new HashMap<>();
		
		for(int i = 0; i < N; i++)
		{
			String name = sc.next();
			char st = sc.next().charAt(0);
			
			if(hs.containsKey(name))
			{
				if(st == '+') arr[hs.get(name)]++;
				else
				{
					if(arr[hs.get(name)] > 0) arr[hs.get(name)]--;
					else res++;
				}
			}
			else
			{
				if(st == '+') arr[idx]++;
				else res++;
				hs.put(name, idx++);
			}
		}
		
		for(int i = 0; i < idx; i++)
			if(arr[i] > 0) res += arr[i];
		System.out.println(res);
	}
}