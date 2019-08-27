import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		HashSet<Long> hs = new HashSet<>();
		
		for(int i = 0; i < N; i++)
			hs.add(sc.nextLong());
		
		for(int i = 0; i < M; i++)
		{
			long num = sc.nextLong();
			if(hs.contains(num))
				hs.remove(num);
		}
		
		System.out.println(hs.size());
		if(hs.size() != 0)
		{
			Object[] arr = hs.toArray();
			Arrays.sort(arr);
			for(Object a : arr)
				System.out.print(a + " ");
		}
	}
}